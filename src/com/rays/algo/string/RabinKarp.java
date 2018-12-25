package com.rays.algo.string;

/**
 * RabinKarp 指纹字符串查找算法
 * 
 * 计算模式字符串的散列函数，计算文本中所有可能的M个字符的字符串散列值寻找匹配。
 * RabinKarp发明了可以在常数时间计算M个字符的字符串散列值方法，因此算法运行时间为线性规模。
 * 
 * 长度为M的字符串对应着一个R进制M位的数字，
 * 
 * @author rays1
 *
 */
public class RabinKarp {
    
    @SuppressWarnings("unused")
    private String pat;         // 模式字符串
    private long   patHash;     // 模式散列值
    private int    M;           // 模式长度
    private long   Q;           // 大素数
    private int    R = 256;     // 字母表大小
    private long   RM;          // R ^ (M-1) % Q
    
    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q =  997;//longRandomPrime();
        RM = 1;
        for (int i = 0; i < M-1; i++) {
            RM = (R*RM) % Q;
        }
        patHash = hash(pat, M);
    }
    
    public int search(String txt) {
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0;
        
        for (int i = M; i < txt.length(); i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (check(i-M+1)) return i - M + 1;
        }
        return -1;
        
    }
    
    private boolean check(int i) {
        return true;
    }
    
    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j ++) {
            h = (R*h+key.charAt(j)) % Q;
        }
        return h;
    }
    
}
