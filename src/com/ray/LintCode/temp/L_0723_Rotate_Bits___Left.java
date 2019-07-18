package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Bit Rotation -—— A rotation (or circular shift) is an operation similar to shift except that the bits that fall off at one end are put back to the other end.
 *      
 *      In left rotation, the bits that fall off at left end are put back at right end.
 *      
 *      Let n is stored using 8 bits. Left rotation of n = 　`11100101` by `3` makes n = `00101111` (Left shifted by 3 and first 3 bits are put back in last ). If n is stored using 16 bits or 32 bits then left rotation of n (`000…11100101`) becomes `00..0011100101000`.
 *      
 *      In this problem, you can assume that n was stored in `32` Bits
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: n = 123, d = 4
 *      Output: 1968
 *      Explanation: 
 *      0000,0000,0000,0000,0000,0000,0111,1010  -->  0000,0000,0000,0000,0000,0111,1010,0000
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: n = 127, d = 8
 *      Output: 32512
 *      Explanation: 
 *      0000,0000,0000,0000,0000,0000,1111,1111  -->  0000,0000,0000,0000,1111,1111,0000,0000
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rotate-bits-left/description
 * @date   2019-07-11 18:35:48
 */
public class L_0723_Rotate_Bits___Left {

    /**
     * 左旋转就是从将数字从左数一定位数，然后将这个位置左右的数字的两部分交换。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        // 恶趣味的方法
        public int leftRotate(int n, int d) {
            return (((n & (-1 << 32 - d)) >> 32 - d) | (n << d));
        }
        
        // 正常写法
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
        
        Out.p(new Solution());
        
    }

}
