package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个 Boolean 表达式，包含如下的元素
 *      标识
 *          T ---> true 
 *          F ---> false
 *      操作符
 *          &   ---> 与
 *          |   ---> 或
 *          ^   ---> 异或
 * 计算有多少种可以将表达式括起来的方式，来使得表达式的计算结果为 true
 * 规定输入的格式是两个数组，一个数组中包含标识（T和F），另一个数组包含操作符（&，| 和 ^）。
 * 
 * 示例
 *      输入
 *          symbol = ['T', 'F', 'T'], operator = ['^', '&']
 *      输出
 *          2
 *          给定的表达式为 T ^ F & T
 *          可以加括号的方式为    ((T ^ F) & T) 和 (T ^ (F & T))
 * 
 * @author rays1
 *
 */
public class L_0725_Boolean_Parenthesization {

    /**
     * 设 
     *      dpP[i][j] 表示 i，j 之间，能够构成的 t 的表达式加括号方式数量
     *      dpN[i][j] 表示 i，j 之间，能够构成的 f 的表达式加括号方式数量
     *      
     * @author rays1
     *
     */
    static class Solution {
    
        public int countParenth(char[] symb, char[] oper) {
            if(symb == null || symb.length == 0 || oper == null || oper.length == 0) return 0;
            int n = symb.length;
            int[][] dpP = new int[n][n];
            int[][] dpN = new int[n][n];
            for(int i = 0;i < n;i ++){
                if(symb[i] == 'T'){
                    dpP[i][i] = 1;
                }else{
                    dpN[i][i] = 1;
                }
            }
            
            for(int j=0;j<n;j++){
                for(int i=j-1;i>=0;i--){
                    dpP[i][j] = 0;
                    dpN[i][j] = 0;
                    
                    for(int k=i;k<j;k++){
                        
                        if (oper[k] == '&') {
                            dpP[i][j] += dpP[i][k]*dpP[k+1][j];
                            dpN[i][j] += (dpP[i][k] + dpN[i][k]) * (dpP[k+1][j] + dpN[k+1][j]) - dpP[i][k] * dpP[k+1][j];
                        }
                        
                        if (oper[k] == '|') {
                            dpP[i][j] += (dpP[i][k] + dpN[i][k]) * (dpP[k+1][j] + dpN[k+1][j]) - dpN[i][k] * dpN[k+1][j];
                            dpN[i][j] += dpN[i][k]*dpN[k+1][j];
                        }
                        
                        if (oper[k] == '^') {
                            dpP[i][j] += dpP[i][k]*dpN[k+1][j] + dpN[i][k]*dpP[k+1][j];
                            dpN[i][j] += dpP[i][k]*dpP[k+1][j] + dpN[i][k]*dpN[k+1][j];
                        }
                        
                    }
                }
            }
            return dpP[0][n-1];
        }

    }
    
    public static void main(String[] args) {
        
        char[] symb = "FTTFFFTTTT".toCharArray();
        char[] oper = "&|^&|&^^^".toCharArray();
        
        Out.p(new Solution().countParenth(symb, oper));
        
    }

}
