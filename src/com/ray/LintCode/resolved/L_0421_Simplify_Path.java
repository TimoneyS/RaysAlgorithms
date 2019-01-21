package com.ray.LintCode.resolved;

import java.util.Stack;

import com.ray.io.Out;

/**
 * 简化文件的绝对路径（Unix风格）
 * 
 * 如
 *      "/home/"            => "/home"
 *      "/a/./b/../../c/"   => "/c"
 * @author rays1
 *
 */
public class L_0421_Simplify_Path {

    /**
     * 用一个栈保存当前路径中的所有文件夹
     * 遇到 . 栈不做操作
     * 遇到 .. 栈中抛出一个文件夹
     * 遇到其他文件夹路径则直接加入栈中
     * 
     * 细节上需要处理 // 的情况，和尾部有 / 的情况，已经当栈已经空了，还有 .. 路径的情况
     * 
     * @author rays1
     *
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
        
        String path = "/home/";
        Out.p(new Solution().simplifyPath(path));
        
    }

}
