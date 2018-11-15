package com.rays.algo.string;

/**
 * 子字符串暴力算法
 * @author rays1
 *
 */
public class ForceSTR {

    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int search(String source, String target) {
        int M = target.length();
        int N = source.length();
        for (int i = 0; i<= N-M; i ++) {
            int j;
            for (j=0; j < M; j++)
                if (source.charAt(i+j) != target.charAt(j))
                    break;
            if (j == M) return i;
        }
        return N;
    }
    
    /**
     * 显示回退的暴力搜索算法
     * @param source
     * @param target
     * @return
     */
    public int search2(String source, String target) {
        
        int j,M = target.length();
        int i,N = source.length();
        
        for (i = 0, j = 0; i < N && j < M; i ++) {
            
            if (source.charAt(i) == target.charAt(j)) {
                j ++;
            } else {
                // 回退本次查找
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        else        return N;
        
    }
    
    
    
    
}
