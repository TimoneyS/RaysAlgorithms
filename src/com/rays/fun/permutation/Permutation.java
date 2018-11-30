package com.rays.fun.permutation;

import static com.ray.util.ArrayUtil.swap;

import java.awt.Color;

import com.ray.gui.StdDraw;
import com.ray.util.TimeUnit;

import static com.ray.util.ArrayUtil.reverse;

public class Permutation {
    
    int k = -1,l = -1;
    
    public void nextPermutation(int[] nums) {
        // 1. 从右侧找第一个 nums[k] < nums[k+1]
        k = findK(nums);
        
        drawArray(nums);
        if (k != -1) {
            // 2. 寻找 l,从右侧找到第一个 nums[l] > nums[k] 的 l 
            l = findL(nums, k);
            drawArray(nums);
            // 3. 交换 nums[k] nums[l]
            swap(nums, k, l);
            drawArray(nums);
        }
        // 4. 翻转 nums[k+1..n]
        reverse(nums, k+1, nums.length-1);
        drawArray(nums);
    }
    
    public int findK(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
    
    public int findL(int[] nums, int k) {
        for (int i = nums.length-1; i > k; i--) {
            if (nums[i] > nums[k]) {
                return i;
            }
        }
        return -1;
    }
    
    public void drawArray(int[] nums) {
        StdDraw.clear();
        int N = nums.length;
        Color c = StdDraw.getPenColor();
        StdDraw.setPenColor(StdDraw.BLUE);
        double rad = 0.4/N;
        for (int i = 0; i < nums.length; i++) {
            
            if (i == k)     StdDraw.setPenColor(StdDraw.RED);
            else if (i==l)  StdDraw.setPenColor(StdDraw.YELLOW);
            else            StdDraw.setPenColor(StdDraw.BLUE);
            
            double x = 0.1 + i * 2*rad + rad / 2;
            double y = 0.1 * nums[i]/2;
            StdDraw.filledRectangle( x, y, rad/2, 0.1 * nums[i]/2);
        }
        StdDraw.setPenColor(c);
        TimeUnit.MILL_SECOND.sleep(10);
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4,5,6,7};
        Permutation p = new Permutation();
        
        while (true) {
            p.nextPermutation(nums);
        }
        
    }
    
}
