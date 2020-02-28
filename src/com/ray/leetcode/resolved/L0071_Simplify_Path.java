package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Stack;

/**
 * Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 * Example:
 *      Example 1
 *      Input: /home/
 *      Output: /home
 *      Explanation: Note that there is no trailing slash after the last directory name.
 *      Example 2
 *      Input: /../
 *      Output: /
 *      Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *      Example 3
 *      Input: /home//foo/
 *      Output: /home/foo
 *      Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *      Example 4
 *      Input: /a/./b/../../c/
 *      Output: /c
 *      Example 5
 *      Input: /a/../../b/../c//.//
 *      Output: /c
 *      Example 6
 *      Input: /a//b////c/d//././/..
 *      Output: /a/b/c
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/simplify-path/
 * @since   2020-02-28 23:06:11
 */
public class L0071_Simplify_Path {
    /**
     * 用一个栈保存当前路径中的所有文件夹
     * 遇到 . 栈不做操作
     * 遇到 .. 栈中抛出一个文件夹
     * 遇到其他文件夹路径则直接加入栈中
     *
     * 细节上需要处理 // 的情况，和尾部有 / 的情况，已经当栈已经空了，还有 .. 路径的情况
     */
    static class Solution {
        public String simplifyPath(String path) {
            path = path + "/";
            Stack<String> stack = new Stack<>();

            int start = -1;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < path.length();i++) {

                char c = path.charAt(i);

                if (path.charAt(i) == '/') {
                    if (start != -1 && i - start > 1) {
                        String dir = sb.toString();
                        if (dir.equals(".")) {

                        } else if (dir.equals("..")) {
                            if (!stack.empty()) stack.pop();
                        } else {
                            stack.push(sb.toString());
                        }
                    }
                    start = i;
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }

            }

            sb = new StringBuilder();
            if (stack.size()==0) stack.push("");
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop()).insert(0, "/");
            }

            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
