package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ray.LintCode.util.Point;
import com.ray.io.Out;

/**
 * 434. Number of Islands II
 *
 * 岛屿数 2
 *
 * 给定数字 n，m 分别表示矩阵的行和列数，给定包含 k 个点的数组
 * 起初矩阵中只包含0，表示只有海洋。数组中存放的点表示所在的位置可以升为岛屿。
 * 
 * 返回每个操作后岛屿的数量
 *
 * @author rays1
 *
 */
public class L_0434_Number_of_Islands_II {

    /**
     * bfs 实现导致内存溢出
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Integer> numIslands2(int n, int m, Point[] operators) {
            
  
            ArrayList<Integer> rs= new ArrayList<>();
            if (operators == null) return rs;
            Map<Integer, Integer> ids = new HashMap<>();
            int count = 0;
            
            Set<Integer> set = new HashSet<>();
            int id = 0;
            
            for (Point p : operators) {
                
                if (ids.containsKey(p.x*m+p.y)) {
                    rs.add(count);
                    continue;
                }
                
                if (p.x > 0   && ids.containsKey((p.x-1)*m+p.y)) set.add(ids.get((p.x-1)*m+p.y));
                if (p.x < n-1 && ids.containsKey((p.x+1)*m+p.y)) set.add(ids.get((p.x+1)*m+p.y));
                if (p.y > 0   && ids.containsKey(p.x*m+p.y-1)) set.add(ids.get(p.x*m+p.y-1));
                if (p.y < m-1 && ids.containsKey(p.x*m+p.y+1)) set.add(ids.get(p.x*m+p.y+1));
                
                id ++;
                ids.put(p.x*m+p.y, id);
                count ++;
                
                count -= set.size();
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (set.contains(ids.get(i*m+j))) {
                            ids.put(i*m+j, id);
                        }
                    }
                }
                set.clear();
                rs.add(count);
                
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        int m = 3;
        
        Point[] operators = {
                new Point(0,1),
                new Point(1,2),
                new Point(2,1),
                new Point(1,0),
                new Point(0,2),
                new Point(0,0),
                new Point(1,1),
        };
        
        Out.p(new Solution().numIslands2(n, m, operators));
        
    }

}
