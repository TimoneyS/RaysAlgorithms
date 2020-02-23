package com.ray.algo.string;

import com.ray.io.Out;

public class Alphabet {
    
    /**
     *  二进制字符集 { 0, 1 }.
     */
    public static final Alphabet BINARY = new Alphabet("01");

    /**
     *  八进制字符集 { 0, 1, 2, 3, 4, 5, 6, 7 }.
     */
    public static final Alphabet OCTAL = new Alphabet("01234567");

    /**
     *  十进制字符集 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }.
     */
    public static final Alphabet DECIMAL = new Alphabet("0123456789");

    /**
     *  十六进制字符集 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F }.
     */
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");

    /**
     *  DNA字符集 { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     *  小写字符集 { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     *  大写字符集 { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     *  蛋白质字符集 { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     *  Base64字符集 (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     *  ASCII字符集 (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     *  扩展的ASCII字符集 (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    /**
     *  Unicode-16字符集 (0-65,535).
     */
    public static final Alphabet UNICODE16      = new Alphabet(65536);

    private char[]      alphabet;       // 字符表中的所有字符
    private int[]       inverse;        // 字符对应的索引
    private final int   R;              // 字符集的范围

    /**
     * 从给定的字符串中初始化一个字符集
     *
     * @param alpha the set of characters
     */
    public Alphabet(String alpha) {

        // 给定的字符串中不能有重复的字母
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++)
            inverse[i] = -1;

        // can't use char since R can be as big as 65,536
        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }

    /**
     * 使用0到R-1的字母初始化一个字符集
     *
     * @param radix 字符集中字母的数目
     */
    private Alphabet(int radix) {
        this.R = radix;
        alphabet = new char[R];
        inverse = new int[R];

        // can't use char since R can be as big as 65,536
        for (int i = 0; i < R; i++)
            alphabet[i] = (char) i;
        for (int i = 0; i < R; i++)
            inverse[i] = i;
    }

    /**
     * 使用0-255的字符初始化字符集
     */
    public Alphabet() {
        this(256);
    }

    /**
     * 如果字母在字符集中返回true
     *
     * @param  c the character
     * @return {@code true} if {@code c} is a character in this alphabet;
     *         {@code false} otherwise
     */
    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    /**
     * 返回字符集中字母的数量
     * 
     * @return the number of characters in this alphabet
     */
    public int radix() {
        return R;
    }

    /**
     * 返回字符集总数的2的幂数（索引需要多少位）
     * 
     * @return the binary logarithm (rounded up) of the number of characters in this alphabet
     */
    public int lgR() {
        int lgR = 0;
        for (int t = R-1; t >= 1; t /= 2)
            lgR++;
        return lgR;
    }

    /**
     * 返回字符对应的索引
     * 
     * @param  c the character
     * @return the index corresponding to the character {@code c}
     * @throws IllegalArgumentException unless {@code c} is a character in this alphabet
     */
    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    /**
     * 返回字符串对应的索引
     * 
     * @param  s the characters
     * @return the indices corresponding to the characters {@code s}
     * @throws IllegalArgumentException unless every character in {@code s}
     *         is a character in this alphabet
     */
    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target  = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }

    /**
     * 返回索引对应的字符
     * 
     * @param  index the index
     * @return the character corresponding to the index {@code index}
     * @throws IllegalArgumentException unless {@code 0 <= index < R}
     */
    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
        }
        return alphabet[index];
    }

    /**
     * 返回索引对应的字符串
     * 
     * @param  indices the indices
     * @return the characters corresponding to the indices {@code indices}
     * @throws IllegalArgumentException unless {@code 0 < indices[i] < R}
     *         for every {@code i}
     */
    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++)
            s.append(toChar(indices[i]));
        return s.toString();
    }

    /**
     * Unit tests the {@code Alphabet} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[]  encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        Out.p(decoded1);
 
        int[]  encoded2 = Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
        String decoded2 = Alphabet.DNA.toChars(encoded2);
        Out.p(decoded2);

        int[]  encoded3 = Alphabet.DECIMAL.toIndices("01234567890123456789");
        String decoded3 = Alphabet.DECIMAL.toChars(encoded3);
        Out.p(decoded3);
        
        int[]  encoded4 = Alphabet.UNICODE16.toIndices("ATCG");
        Out.p(encoded4);
        
        Out.p(encoded2);
    }

}
