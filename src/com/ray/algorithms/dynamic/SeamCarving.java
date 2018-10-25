package com.ray.algorithms.dynamic;

import java.awt.Color;

import com.ray.gui.Picture;
import com.ray.io.In;
import com.ray.io.Out;

/**
 * 基于接缝裁剪的图像压缩
 * @author rays1
 *
 */
public class SeamCarving {
    
    private int maxSeamEnergy;
    private int[][] energy;
    private int[][] picture;
    private int width;
    private int height;
    
    public SeamCarving(Picture picture) {
        
        width = picture.width();
        height = picture.height();
        
        maxSeamEnergy = Math.max(width, height) * 1000;
        
        energy = new int[width][height];
        this.picture = new int[width][height];
        
        // 处理图片到 RGB 格式
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.picture[i][j] = picture.getRGB(i, j);
            }
        }
        // 计算能量
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                energy[i][j] = computePixelEnergy(i, j);
            }
        }
        
    }
    
    /**
     * 垂直方向接缝裁剪
     * @return
     */
    public int[] verticalSeamCarving() {
        
        int[] seam = new int[height];
        int[][] seamEnergy = new int[width][height];
        int[][] pathTo = new int[width][height];
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                seamEnergy[i][j] = -1;
            }
        }
        
        for (int i = 0; i < width; i ++) {
            seamEnergy(i, 0, seamEnergy, pathTo);
        }
        
        int minIndex = 0;
        for (int i = 0; i < width; i++) {
            if (seamEnergy[minIndex][0] > seamEnergy[i][0]) {
                minIndex = i;
            }
        }
        
        seam[0] = minIndex;
        for (int i = 1; i < height; i ++) {
            seam[i] = pathTo[seam[i-1]][i];
        }
        
        return seam;
    }
    
    public int[] horizontalSeamCarving() {
        return null;
    }

    private int seamEnergy(int i, int j, int[][] seamEnergy, int[][] pathTo) {
        
        if (i < 0 || i >= width) return maxSeamEnergy;
        
        if (seamEnergy[i][j] == -1) { // 没有备忘
            
            if (j == height-1) { // 最后一行
                seamEnergy[i][j] = energy[i][j];
            } else {
                
                int a = seamEnergy(i - 1, j + 1, seamEnergy, pathTo);
                int b = seamEnergy(    i, j + 1, seamEnergy, pathTo);
                int c = seamEnergy(i + 1, j + 1, seamEnergy, pathTo);
                
                if (a <= b && a <= c) { // 左侧最小
                    pathTo[i][j] = i - 1;
                    seamEnergy[i][j] = energy[i][j] + a;
                } else if (b <= c && b <= a) { // 中间最小
                    pathTo[i][j] = i;
                    seamEnergy[i][j] = energy[i][j] + b;
                } else { // 右侧最小
                    pathTo[i][j] = i + 1;
                    seamEnergy[i][j] = energy[i][j] + c;
                }
                
            }
        }
        return seamEnergy[i][j];
    }
    
    
    public void showSeam(Picture pic, int[] seam) {
        for (int i = 0; i < height; i++) {
            int j = seam[i];
            pic.set(i, j, Color.WHITE);
        }
    }
    
    /**
     * 裁剪接缝
     * @param seam
     */
    public void removeVerticalSeam(int[] seam) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int j = 0; j < height; j++) {
            if (seam[j] > max)
                max = seam[j];
            if (seam[j] < min)
                min = seam[j];

            for (int i = seam[j]; i < width - 1; i++) {
                picture[i][j] = picture[i+1][j];
            }
        }

        width--;
        if (min > 0)
            min --;
        if (max > height - 1)
            max = height - 1;

        for (int j = 0; j < height; j++) {
            for (int i = min; i <= max; i++)
                energy[j][i] = computePixelEnergy(j, i);
            for (int i = max + 1; i < height - 1; i++)
                energy[j][i] = energy[j][i + 1];
        }

    }
    
    private int computePixelEnergy(int i, int j) {
        
        if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
            return 1000;
        }
        
        int rgbUp = picture[i][j - 1];
        int rgbDown = picture[i][j + 1];
        int rgbLeft = picture[i - 1][j];
        int rgbRight = picture[i + 1][j];

        int rx = Math.abs(((rgbLeft >> 16) & 0xFF) - ((rgbRight >> 16) & 0xFF));
        int gx = Math.abs(((rgbLeft >> 8) & 0xFF) - ((rgbRight >> 8) & 0xFF));
        int bx = Math.abs(((rgbLeft >> 0) & 0xFF) - ((rgbRight >> 0) & 0xFF));

        int ry = Math.abs(((rgbUp >> 16) & 0xFF) - ((rgbDown >> 16) & 0xFF));
        int gy = Math.abs(((rgbUp >> 8) & 0xFF) - ((rgbDown >> 8) & 0xFF));
        int by = Math.abs(((rgbUp >> 0) & 0xFF) - ((rgbDown >> 0) & 0xFF));
        
        return (int) Math.sqrt(rx*rx + gx*gx + bx*bx + ry*ry + gy*gy + by*by);
        
//        return rx + gx + bx + ry + gy + by;
    } 
    
    // current picture
    public Picture picture() {
        Picture pic = new Picture(width, height);
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                pic.setRGB(i, j, picture[i][j]);
        return pic;
    }
    
    public static void main(String[] args) {
        
//        Picture pic = new Picture(9, 9);
//
//        
//        pic.set(4, 4, new Color(255,255,255));
//        
//        pic.set(4, 3, new Color(0,0,0));
//        pic.set(4, 5, new Color(255,255,255));
//        pic.set(3, 4, new Color(0,0,0));
//        pic.set(5, 4, new Color(255,255,255));
//        
//        SeamCarving sc = new SeamCarving(pic);
//        
//        Out.p(sc.picture, "%9s ");
//        Out.sep();
//        Out.p(sc.energy, "%4s ");
        
        
        Picture pic = new Picture(In.getClassPathResource(SeamCarving.class, "light.jpg"));
        
        SeamCarving sc = new SeamCarving(pic);
        
        pic.show();
        
        for (int i = 0; i < 100; i++) {
            Out.p(i);
            int[] seam = sc.verticalSeamCarving();
        
            sc.removeVerticalSeam(seam);
        
        }
        
        sc.picture().show();
        
    }
    
}
