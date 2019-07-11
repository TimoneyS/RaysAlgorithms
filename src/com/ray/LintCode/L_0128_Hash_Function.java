package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      <p>In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:</p><p>hashcode("abcd") = (ascii(a) * 33<sup>3</sup> +&nbsp;<span style="line-height: 1.42857143;">ascii(</span><span style="line-height: 1.42857143;">b) * 33</span><sup>2</sup><span style="line-height: 1.42857143;"> +&nbsp;</span><span style="line-height: 1.42857143;">ascii(</span><span style="line-height: 1.42857143;">c) *33 +&nbsp;</span><span style="line-height: 1.42857143;">ascii(</span><span style="line-height: 1.42857143;">d)) %&nbsp;</span>HASH_SIZE<span style="line-height: 1.42857143;">&nbsp;</span></p><p><span style="line-height: 1.42857143;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; = (</span><span style="line-height: 1.42857143;">97* 33</span><span style="font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em;">3</span><span style="line-height: 1.42857143;">&nbsp;</span><span style="line-height: 1.42857143;">+ 98</span><span style="line-height: 1.42857143;">&nbsp;* 33</span><span style="font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em;">2</span><span style="line-height: 1.42857143;">&nbsp;+ 99</span><span style="line-height: 1.42857143;">&nbsp;* 33 +100</span><span style="line-height: 1.42857143;">) % HASH_SIZE</span></p><p><span style="line-height: 1.42857143;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; =&nbsp;</span>3595978 % HASH_SIZE</p><p>here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).</p><p>Given a string as a key and the size of hash table, return the hash value of this key.</p><p><br></p>
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:  key="abcd", size = 1000
 *      Output: 978
 *      Explanation: (97*33^3 + 98*33^2 + 99*33 + 100*1)%1000 = 978
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:  key="abcd", size = 100
 *      Output: 78
 *      Explanation: (97*33^3 + 98*33^2 + 99*33 + 100*1)%100 = 78
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/hash-function/description
 * @date   2019-07-11 18:30:55
 */
public class L_0128_Hash_Function {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
