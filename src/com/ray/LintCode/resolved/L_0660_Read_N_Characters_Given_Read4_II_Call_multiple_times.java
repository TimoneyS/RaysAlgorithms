package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * int read4(char *buf) 方法一次可以从文件中读取4个字符
 * 返回值是实际读取到的字符个数（文件可能剩余不够4个字符）
 * 
 * 使用 read4 方法，实现一个读取任意 n 个数字符的方法。
 *
 * @author rays1
 *
 */
public class L_0660_Read_N_Characters_Given_Read4_II_Call_multiple_times {

    static class Reader4 {
        public int read4(char[] buf) { return 0; }
    }
    
    /**
     * 需要注意的几个个点就是
     *      1. 上一次的读取的 字符可能用不完，那么下一次读的时候，需要使用上
     *      2. 上一次读取后剩余的字符，下一次读取后可能依然用不完
     *      3. 要考虑文件长度不够和读取的长度之间的关系。
     * 
     * @author rays1
     *
     */
    static class Solution extends Reader4 {
    
        char[] buf4 = new char[4];
        int total = 0, used = 0;
        
        public int read(char[] buf, int n) {
            
            // 本次读取的字符数
            int cursor = 0;
            
            // 上一次的字符没有读取完毕
            if (total > used) while (cursor < n && used < total) buf[cursor++] = buf4[used++];
            
            // 如果 cursor >= n 说明上一次的缓冲字符足够本次读取使用，不需要再读取文件
            while (cursor < n && (total = read4(buf4)) > 0) {
                used = 0;
                while (cursor < n && used < total) buf[cursor++] = buf4[used++];
            }
            
            return cursor;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
