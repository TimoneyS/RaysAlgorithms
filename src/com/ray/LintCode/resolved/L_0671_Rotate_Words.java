package com.ray.LintCode.resolved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.ray.io.Out;

/**
 * 将一个的单词旋转之后得到一个新的单词，这两单词就互为旋转单词。
 *      例如 picture -> turepic -> repictu
 * 
 * 统计一个字典中，存在多少个旋转单词
 *
 *
 * @author rays1
 *
 */
public class L_0671_Rotate_Words {

    /**
     * 旋转单词具有传递性，每组旋转单词只需要保存一个代表即可。
     * 
     * 判断是否时单词需要一次查询，复杂度根据算法不同，在 size 和 size^2 之间
     * 这里偷懒，存储的时候使用了 s + s，这样保证所有可能的旋转单词都在这个字符串之中
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int countRotateWords(List<String> words) {
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                boolean flag = true;
                for (String s : set) {
                    if (s.indexOf(word) != -1 && s.length() == word.length() * 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag)set.add(word+word);
            }
            return set.size();
        }
    
    }
    
    public static void main(String[] args) {
        
        String[] ss = {"a", "aa", "ab", "ba", "lintcode", "codelint", "odelintc"};
        List<String> words = Arrays.asList(ss);
        Out.p(new Solution().countRotateWords(words));
    }

}
