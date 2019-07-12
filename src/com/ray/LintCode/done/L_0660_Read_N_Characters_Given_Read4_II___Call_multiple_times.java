package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      The API: `int read4(char *buf)` reads `4` characters at a time from a file.
 *      
 *      The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 *      
 *      By using the read4 API, implement the function `int read(char *buf, int n)` that reads n characters from the file.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      "filetestbuffer"
 *      read(6)
 *      read(5)
 *      read(4)
 *      read(3)
 *      read(2)
 *      read(1)
 *      read(10)
 *      Output:
 *      6, buf = "filete"
 *      5, buf = "stbuf"
 *      3, buf = "fer"
 *      0, buf = ""
 *      0, buf = ""
 *      0, buf = ""
 *      0, buf = ""
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      "abcdef"
 *      read(1)
 *      read(5)
 *      Output:
 *      1, buf = "a"
 *      5, buf = "bcdef"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/read-n-characters-given-read4-ii-call-multiple-times/description
 * @date   2019-07-11 18:35:11
 */
public class L_0660_Read_N_Characters_Given_Read4_II___Call_multiple_times {

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
