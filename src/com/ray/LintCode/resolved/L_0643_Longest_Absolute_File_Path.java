package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 假设按照如下的字符串来抽象文件系统：
 *      字符串 "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 表示：
 *          dir
 *           |-- subdir1
 *           |-- subdir2
 *                |-- file.ext
 * 
 *      字符串 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 表示
 *           dir
 *            |-- subdir1
 *            |   |-- file1.ext
 *            |   |-- subsubdir1
 *            |--subdir2
 *                |-- subsubdir2
 *                     |-- file2.ext
 * 
 * 给定一个文件系统的字符串表示，返回到某个文件的最长绝对路径的长度，如果文件系统中不包含文件，返回 0
 * 
 * 例如：
 *      在第二个例子中最长的绝对路径 为 "dir/subdir2/subsubdir2/file2.ext"，其长度为 32 （不包含双引号）
 *      
 * 注意：
 *      文件名至少包含一个 . 和一个扩展名
 *      文件夹名称不包含 .
 *      时间复杂度为O(n)
 *      需要注意的是最长绝对路径不代表文件的层级更深，如果某个文件名称更长也可能是需要的结果
 *          比如 a/aa/aaa/file1.txt 和 aaaaaaaaaaaaaaaaaaaaa/sth.png，应该返回后者
 * 
 * @author rays1
 *
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
        // dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
        
        
//         String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//         String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input = "dir\n file.txt";
        
        Out.p(new Solution().lengthLongestPath(input));
        
    }

}
