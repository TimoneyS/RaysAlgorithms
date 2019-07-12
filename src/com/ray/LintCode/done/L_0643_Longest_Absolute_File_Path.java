package com.ray.LintCode.done;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 描述：
 *      Suppose we abstract our file system by a string in the following manner:
 *      
 *      The string `"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"` represents:
 *      ```
 *      dir
 *          subdir1
 *          subdir2
 *              file.ext
 *      ```
 *      The directory `dir` contains an empty sub-directory `subdir1` and a sub-directory `subdir2` containing a file file.ext.
 *      
 *      The string
 *      ```
 *      "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 *      ``` 
 *      represents:
 *      ```
 *      dir
 *          subdir1
 *              file1.ext
 *              subsubdir1
 *          subdir2
 *              subsubdir2
 *                  file2.ext
 *      ```
 *      The directory `dir` contains two sub-directories `subdir1` and `subdir2`. `subdir1` contains a file file1.ext and an empty second-level sub-directory `subsubdir1`. `subdir2` contains a second-level sub-directory `subsubdir2` containing a file `file2.ext`.
 *      
 *      We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is `"dir/subdir2/subsubdir2/file2.ext"`, and its length is `32` (not including the double quotes).
 *      
 *      Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return `0`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 *      Output: 20
 *      Explanation:
 *      See description for details.
 *      ```
 *      **Example2**
 *      ```
 *      Input: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 *      Output: 32
 *      Explanation:
 *      See description for details.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/longest-absolute-file-path/description
 * @date   2019-07-11 18:34:43
 */
public class L_0643_Longest_Absolute_File_Path {

    /**
     * 这种字符串抽象的路径模式相当于树的前序遍历
     * 
     * 维护一个栈，保存遍历到的目录，栈中的每个目录都是其之前的元素的直接子目录
     *      如果新的目录层级大于栈顶的目录，则将新目录加入栈重
     *      如果新的目录层级小于栈顶的目录，则说明栈顶的目录属于新的目录的兄弟目录，需要不断的抛出栈中的目录，直到遇到一个小于新目录的目录
     *          这个目录也就是新的目录的父目录。
     * 
     *      如果新的目录是一个文件，那么栈中的目录恰好构成完整的绝对路径，计算这个路径的长度即可。
     *      
     * 实际算法中，因为算法返回的是长处，因此不需要保存具体的目录名称，只要保存目录的长度和层级即可。     
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int lengthLongestPath(String input) {
            
            int i = input.indexOf('\n');
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[] {1, i});
            i++;
            
            int rs = Math.max(0, i);
            while (i < input.length() && i > 0) {
                
                // 计算当前目录或文件的层级
                int level = 1;
                while (input.charAt(i) == '\t') {
                    i++;
                    level ++;
                }
                
                // 计算当前目录或文件名称的长度，同时判断是否是文件
                int len = 0;
                boolean isFile = false;
                while (i < input.length() && input.charAt(i) != '\n') {
                    if (input.charAt(i) == '.') isFile = true;
                    len ++;
                    i ++;
                }
                i++;
                
                //
                while (!stack.isEmpty() && level <= stack.peek()[0]) stack.pop();
                
                if (isFile) {
                    for (int[] arr : stack) len += 1 + arr[1];
                    rs = Math.max(rs, len);
                } else {
                    stack.push(new int[] {level, len});
                }
                
            }
                
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
