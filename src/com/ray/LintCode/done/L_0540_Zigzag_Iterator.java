package com.ray.LintCode.done;

import java.util.Iterator;
import java.util.List;

/**
 * 描述：
 *      Given two **1d** vectors, implement an iterator to return their elements alternately.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: v1 = [1, 2] and v2 = [3, 4, 5, 6]
 *      Output: [1, 3, 2, 4, 5, 6]
 *      Explanation: 
 *      By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: v1 = [1, 1, 1, 1] and v2 = [3, 4, 5, 6]
 *      Output: [1, 3, 1, 4, 1, 5, 1, 6]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/zigzag-iterator/description
 * @date   2019-07-11 18:33:53
 */
public class L_0540_Zigzag_Iterator {

    /**
     * 使用内置迭代器，每次迭代，交换迭代器的顺序即可，
     * 当然也可以通过状态的形式表示，具体略
     * 
     * @author rays1
     *
     */
    static class ZigzagIterator {

        Iterator<Integer> i1, i2;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            i1 = v1.iterator();
            i2 = v2.iterator();
        }

        public int next() {
            int rs = 0;
            if (i1.hasNext()) {
                rs = i1.next();
            } else {
                rs = i2.next();
            }
            Iterator<Integer> t = i1;
            i1 = i2;
            i2 = t;
            return rs;
        }

        public boolean hasNext() {
            return i1.hasNext() || i2.hasNext();
        }
        
    }
    
    public static void main(String[] args) {
        
        
    }

}
