package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.HashSet;

import com.ray.io.Out;

/**
 * 一个单词的缩写遵顼如下的格式：
 *  a) it                      --> it    (no abbreviation)
 *
 *      1
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * 
 * 假设有一个字典和一个单词，判断单词的缩写在字典中是否是唯一的（即字典中没有其它单词的缩写和该缩写象用）。
 *
 * @author rays1
 *
 */
public class L_0648_Unique_Word_Abbreviation {

    static class ValidWordAbbr {
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        public ValidWordAbbr(String[] dictionary) {
            for (String word : dictionary) {
                String abbr = getAbbr(word);
                map.putIfAbsent(abbr, new HashSet<>());
                map.get(abbr).add(word);
            }
        }
        
        public boolean isUnique(String word) {
            String abbr = getAbbr(word);
            HashSet<String> set = map.get(abbr);
            return set == null  || set.size() == 1 && set.contains(word);
        }

        String getAbbr(String str) {
            if (str.length() <= 2) {
                return str;
            }
            return "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
        }
        
        void unique(String s) {
            Out.p(isUnique(s));
        }
        
    }
    
    static void isUnique() {
        
    }
    
    public static void main(String[] args) {
     
        String[] dict = {"deer","door","cake","card"}; 
        ValidWordAbbr v = new ValidWordAbbr(dict);
        v.unique("dear");
        v.unique("cart");
        v.unique("cane");
        v.unique("make");
    }

}
