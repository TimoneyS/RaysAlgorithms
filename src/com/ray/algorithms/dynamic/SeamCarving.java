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
    
    private int[][] energy;
    private int[][] picture;
    private int width;
    private int height;
    
    public SeamCarving(Picture picture) {
        
        width = picture.width();
        height = picture.height();
        
        energy = new int[height][width];
        this.picture = new int[height][width];
        
        // 处理图片到 RGB 格式
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.picture[i][j] = picture.getRGB(j, i);
            }
        }
        
        computeEnergy();
        
    }
    
    /**
     * 垂直方向接缝裁剪
     * @return
     */
    public int[] verticalSeamCarving() {
        
        int[] seam = new int[height];
        int[][] seamEnergy = new int[height][width];
        int[][] pathTo = new int[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
//                if (i == 0)
//                    seamEnergy[i][j] = energy[i][j];
//                else
                    seamEnergy[i][j] = -1;
            }
        }
        
        for (int j = 0; j < width; j ++) {
            seamEnergy(0, j, seamEnergy, pathTo);
        }
        
        int minIndex = 0;
        for (int i = 0; i < width; i++) {
            if (seamEnergy[0][minIndex] > seamEnergy[0][i]) {
                minIndex = i;
            }
        }
        
        seam[0] = minIndex;
        for (int i = 1; i < height; i ++) {
            seam[i] = pathTo[i][seam[i-1]];
        }
        
        return seam;
    }
    
    public int[] horizontalSeamCarving() {
        return null;
    }
    
    public void showSeam(Picture pic, int[] seam) {
        for (int j = 0; j < height; j++) {
            int i = seam[j];
            pic.set(i, j, Color.WHITE);
        }
    }

    private int seamEnergy(int i, int j, int[][] seamEnergy, int[][] pathTo) {
        
        if (seamEnergy[i][j] == -1) { // 没有备忘
            
            if (i == height-1) {
                seamEnergy[i][j] = energy[i][j];
            } else {
                int a = 20000, b = 20000, c = 20000;
                
                if (j > 0)
                    a = seamEnergy(i + 1, j - 1, seamEnergy, pathTo);
                
                b = seamEnergy(i+1, j, seamEnergy, pathTo);
                
                if (j < width-1)
                    c = seamEnergy(i + 1, j + 1, seamEnergy, pathTo);
                
                if (a <= b && a <= c) {
                    // 左侧最小
                    pathTo[i][j] = j-1;
                    seamEnergy[i][j] = energy[i][j] + a;
                } else if (b <= c && b <= a) {
                    // 中间最小
                    pathTo[i][j] = j;
                    seamEnergy[i][j] = energy[i][j] + b;
                } else {
                    // 右侧最小
                    pathTo[i][j] = j+1;
                    seamEnergy[i][j] = energy[i][j] + c;
                }
                
            }
        }
        return seamEnergy[i][j];
    }
    
  public void removeVerticalSeam(int[] seam) {
        
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < height; i++) {
            if (seam[i] > max)
                max = seam[i];
            if (seam[i] < min)
                min = seam[i];

            for (int j = seam[i]; j < width - 1; j++) {
                picture[i][j] = picture[i][j+1];
            }
        }

        width --;
        if (min > 0)
            min--;
        if (max > height - 1)
            max = height - 1;

        for (int i = 0; i < height; i++) {
            for (int j = min; j <= max; j++)
                energy[i][j] = computePixelEnergy(i, j);
            for (int j = max + 1; j < height - 1; j++)
                energy[i][j] = energy[i][j+1];
        }
        
    }
    
    public void computeEnergy() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                energy[i][j] = computePixelEnergy(i, j);
            }
        }
    }
    
    private int computePixelEnergy(int i, int j) {
        if (i == 0 || j == 0 || i == height-1 || j == width - 1) {
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
        
        return rx + gx + bx + ry + gy + by;
    }
    
    // current picture
    public Picture picture() {
        Picture pic = new Picture(width, height);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                pic.setRGB(j, i, picture[i][j]);

        return pic;
    }
    
    public static void main(String[] args) {
        
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
