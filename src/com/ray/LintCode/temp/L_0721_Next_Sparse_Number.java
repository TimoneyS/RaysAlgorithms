package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      A number is Sparse if there are no two adjacent `1`s in its `binary representation`. Given a number `n`, find the smallest Sparse number which greater than or equal to `n`.
 *      eg. `5` (binary representation: `101`) is sparse, but `6` (binary representation: `110`) is not sparse.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：6
 *      Output：8
 *      Explanation：
 *      6 = 110(2) and 8 = 1000(2)
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：13
 *      Output：16
 *      Explanation：
 *      13 = 1101(2) and 16 =10000(2) 
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/next-sparse-number/description
 * @date   2019-07-11 18:35:47
 */
public class L_0721_Next_Sparse_Number {


    /**
     *      1011 -> 1 0000
     *    1 0011 -> 1 0100
     *    
     * 从数字的二进制形式的左侧开始找  ，可能情况如下：
     *      1. 如果数字中不存在 11相连，则数字是稀疏数，直接返回原数字
     * 
     *      2. 如果数字中存在 11 相连，则数字有两种可能
     *          2.1 相连的 11 左侧有两个以上的 0
     *              如   100110，此时只需要将 11 和之后所有数字变为 0 然后将左侧最近的 0 变为 1，即
     *                  100110 -> 101000
     *          2.2 相连的 11 左侧有一个 0
     *              那么11左侧一定是 10的形式，因为是从左向右找，如果左侧是 11，循环无法到达此处。
     *              由此可得左侧的数字 一定是 10101010 的形式
     *              那么只要记录这个 101010 的开始的坐标l，其左侧要么是 00 要么是数字开始
     *              无论何种情况都只要将 l 变为 1，l 之后的所有位变为0即可。
     *    
     * @author rays1
     *
     */
    static class Solution {
    
        public int nextSparseNum(int x) {
            String s = new String(Integer.toBinaryString(x));
            char prev = '0'; int l = -1, r = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0' && prev == '0') l = i;
                if (s.charAt(i) == '1' && prev == '1') {
                    r = i-1;
                    break;
                }
                prev = s.charAt(i);
            }
            if (r == -1)
                return x;
            else if (l == -1) {
                return 1 << s.length();
            } else {
                // 将数字的某位设置为 1 然后将之后的位设置为 0
                return ((x >> s.length() - l - 1) + 1) << s.length() - l - 1;
            }
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
