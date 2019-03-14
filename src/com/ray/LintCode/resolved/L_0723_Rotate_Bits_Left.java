package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 位旋转
 * n 是 32位二进制的数字（包括前面的 0），给定位数 d，输出左旋转 d 位后的值。
 * 旋转就是从某一侧数 d 位，用这个 d 个数字和剩下的数字交换。
 * 
 * 示例
 *      输入‭
 *          n = 2145863788‬
 *          d = 5
 *      ‭输出   
 *          n 的32位表示如下
 *              0111 1111 1110 0111 0100 1000 0110 1100‬ + 
 *          左旋转 5 位
 *              111 1110 0111 0100 1000 0110 1100‬ + 0111 1
 *
 * @author rays1
 *
 */
public class L_0723_Rotate_Bits_Left {

    static class Solution {
    
        // 恶趣味的方法
        public int leftRotate(int n, int d) {
            return (((n & (-1 << 32 - d)) >> 32 - d) | (n << d));
        }
        
        public int leftRotateOld(int n, int d) {
            // 参数
            int bit = 32, mask = 0;
            // 待旋转的左右部分
            int l = 0, r = 0;
            // 获取前 d 位，并右移动
            mask = -1 << bit - d;
            l = ((n & mask) >> bit-d);
            // 获取后 n-d 位，并左移
            r = n << d;
            return (l | r);
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = Integer.MAX_VALUE;
        int d = 1;
        
        Out.p(new Solution().leftRotate(n, d));
        
    }

}
