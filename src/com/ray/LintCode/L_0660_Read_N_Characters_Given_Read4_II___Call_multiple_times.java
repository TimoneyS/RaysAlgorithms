package com.ray.LintCode;

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

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
