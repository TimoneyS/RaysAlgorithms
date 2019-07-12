package com.ray.LintCode.done;

import java.util.Iterator;
import java.util.List;

/**
 * 描述：
 *      Implement an iterator to flatten a 2d vector.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:[[1,2],[3],[4,5,6]]
 *      Output:[1,2,3,4,5,6]
 *      ```
 *      Example 2:
 *      ```
 *      Input:[[7,9],[5]]
 *      Output:[7,9,5]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flatten-2d-vector/description
 * @date   2019-07-11 18:34:25
 */
public class L_0601_Flatten_2D_Vector {

    static public class Vector2D implements Iterator<Integer> {

        Iterator<List<Integer>> m;
        Iterator<Integer> s;
        
        public Vector2D(List<List<Integer>> vec2d) {
            m = vec2d.iterator();
            valid();
        }

        @Override
        public Integer next() {
            Integer rs = s.next();
            valid();
            return rs;
        }
        
        private void valid() {
            while (true) {
                if (s != null && s.hasNext()) return;
                if (m.hasNext()) {
                    s = m.next().iterator();
                } else {
                    return;
                }
                
            }
        }

        @Override
        public boolean hasNext() {
            return s != null && s.hasNext();
        }

        @Override
        public void remove() {}
    }
    
    public static void main(String[] args) {
        
        
    }

}
