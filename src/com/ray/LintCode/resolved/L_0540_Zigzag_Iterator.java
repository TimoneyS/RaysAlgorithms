package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.ray.io.Out;

/**
 * 给定两个1d向量，实现迭代器以交替返回其元素。
 * 
 * 例如 
 *      v1 = [1, 2]
 *      v2 = [3, 4, 5, 6]
 *
 *  迭代顺序为 [1, 3, 2, 4, 5, 6]
 *
 * @author rays1
 *
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
        
        List<Integer> v1 = Arrays.asList(new Integer[] {1,2});
        List<Integer> v2 = Arrays.asList(new Integer[] {3,4,5,6});
        
        ZigzagIterator ite = new ZigzagIterator(v1, v2);
        while (ite.hasNext()) {
            Out.pt(ite.next() + ", ");
        }
    }

}
