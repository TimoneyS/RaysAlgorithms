package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Maximum Product of Word Lengths
 * -----------------------------------------------------------------------------
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example:
 *      Example 1
 *      Input: [abcw,baz,foo,bar,xtfn,abcdef]
 *      Output: 16 
 *      Explanation: The two words can be abcw, xtfn.
 *      Example 2
 *      Input: [a,ab,abc,d,cd,bcd,abcd]
 *      Output: 4 
 *      Explanation: The two words can be ab, cd.
 *      Example 3
 *      Input: [a,aa,aaa,aaaa]
 *      Output: 0 
 *      Explanation: No such pair of words.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * @since   2020-03-11 20:45:36
 */
public class L0318_Maximum_Product_of_Word_Lengths {
    /**
     * 用二进制位表示字符在单词是否存在，那么每个单词都会对应一个 hash
     * 如果两个单词的hash 与的结果位 0则两个单词没有重复
     */
    static class Solution {
        public int maxProduct(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
            int[] hash = new int[words.length];
            for (int i = 0; i < hash.length; i++)
                hash[i] = hash(words[i]);

            int max = 0;
            int x = 0, y = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if ( (hash[i] & hash[j]) == 0) {
                       max = Math.max(max, words[i].length() * words[j].length());
                       Out.pf("%s, %s \n", words[i].length(), words[j].length());
                       break;
                    }
                }
            }

            return max;
        }

        private int hash(String word) {
            int hash = 0;
            for (int i = 0; i < word.length(); i++)
                hash |= (1 << (word.charAt(i) - 'a'));
            return hash;
        }
    }
    
    public static void main(String[] args) {
        String[] words = {"ccd","accaceddeeeaefc","bcaffa","bbcfafbb","accacfebbabbeedfbfdb","beddecbffcdaededdaefdedfdea","cf","ddafdcbd","bbafacebacaefdaffccebddff","ebccffcddbeddccacceccaec","becfbfdccdfdeadfbfaddbcded","cbabeaaeabefedbaeaedc","dfadbbdbead","cafaefdcd","eccdbfceafeeeacfcddc","dbabbcdbb","abfbfbffcbebde","cfaadaa","fc","faebcabb","adbacebabcaaccbdeaffff","aeaefccf","dbacbeeabdbcdfccabebaecfef","ecdadeefcaddffaececffa","defcabf","abbcecbccbdaebaecaefabed","dfeeebcbaaefc","aecccbcbbdddb","dcfabacec","fccfbacbacddeaaea","dfdbfacbacbecb","cbfeebdbfecb","cffaacacbde","aafd","bdcebbbebd","afeffadcfcdacfba","dafeefbcdfaffcfacee","dcbbebfbedafedcdbab","cafaf","bcbcccfdebdd","efaaaacccff","cffbead","ebcfccfcddffdec","fffdfdcec","beeafefbdfa","cdfdbccfbaaeffcabab","ddadcbabbcb","decfaeabbecebaebeaddedae","cdcbfffbebae","aeccefcbcbbddfdc","ffefedaf","cddbabccafaffeafeedcbedbdad","eddeeccfedcefadfdfebfacb","aca","ffdcafaddcddf","ef","bbbbffe","ffccfebabaadcffacbbb","cbdeddfddffacbeeeebafebabda","ddeecb","cffdc","edcffcebadf","becbcadcafddcfbbeeddbfffcab","abcbaceeaeaddd","cfeffceebfaeefadaaccfa","eaccddb","caeafbfafecd","becaafdbaadbfecfdfde","ecabaaeafbfbcbadaac","bdcdffcfaeebeedfdfddfaf","dbbfbaeecbfcdebad","cceecddeeecdbde","beec","adbcfdbfdbccdcffffbcffbec","bbbbfe","cdaedaeaad","dadbfeafadd","fcacaaebcedfbfbcddfc","ceecfedceac","dada","ccfdaeffbcfcc","eadddbbbdfa","beb","fcaaedadabbbeacabefdabe","dfcddeeffbeec","defbdbeffebfceaedffbfee","cffadadfbaebfdbadebc","fbbadfccbeffbdeabecc","bdabbffeefeccb","bdeeddc","afcbacdeefbcecff","cfeaebbbadacbced","edfddfedbcfecfedb","faed","cbcdccfcbdebabc","efb","dbddadfcddbd","fbaefdfebeeacbdfbdcdddcbefc","cbbfaccdbffde","adbcabaffebdffad"};
        Out.p(new Solution().maxProduct(words));
    }
}
