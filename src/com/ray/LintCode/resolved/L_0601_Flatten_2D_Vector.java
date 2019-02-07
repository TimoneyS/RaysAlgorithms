package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.ray.io.Out;

/**
 * 实现 2维向量的迭代
 *
 *
 * @author rays1
 *
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
        
        List<List<Integer>> vec2d = new ArrayList<>();
        
        vec2d.add(Arrays.asList(new Integer[] {}));
        vec2d.add(Arrays.asList(new Integer[] {1,2}));
        vec2d.add(Arrays.asList(new Integer[] {}));
        
        Vector2D v2 = new Vector2D(vec2d);
        
        while (v2.hasNext()) {
            Out.p(v2.next());
        }
        
    }

}
