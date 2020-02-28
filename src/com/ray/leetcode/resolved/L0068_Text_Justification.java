package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification
 * 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 说明:
 *      单词是指由非空格字符组成的字符序列。
 *      每个单词的长度大于 0，小于等于 maxWidth。
 *      输入单词数组 words 至少包含一个单词。
 * Example:
 *      Example 1
 *      Input:
 *      words = [This, is, an, example, of, text, justification.]
 *      maxWidth = 16
 *      Output:
 *      [
 *         This    is    an,
 *         example  of text,
 *         justification.
 *      ]
 *      Example 2
 *      Input:
 *      words = [What,must,be,acknowledgment,shall,be]
 *      maxWidth = 16
 *      Output:
 *      [
 *        What   must   be,
 *        acknowledgment  ,
 *        shall be
 *      ]
 *      Explanation: Note that the last line is shall be     instead of shall     be,
 *                   because the last line must be left-justified instead of fully-justified.
 *                   Note that the second line is also left-justified becase it contains only one word.
 *      Example 3
 *      Input:
 *      words = [Science,is,what,we,understand,well,enough,to,explain,
 *               to,a,computer.,Art,is,everything,else,we,do]
 *      maxWidth = 20
 *      Output:
 *      [
 *        Science  is  what we,
 *        understand      well,
 *        enough to explain to,
 *        a  computer.  Art is,
 *        everything  else  we,
 *        do
 *      ]
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/text-justification/
 * @since   2020-02-27 23:19:27
 */
public class L0068_Text_Justification {
    /**
     * 先找出恰好一行能够容下的单词
     *
     * 然后平均分配空格到这些单词的间隙
     *
     * 空格的总数 s = 宽度 - 单词总字符数
     * 间隙的个数 c = 单词数 - 1
     *
     * 那么方法的核心就是要让 s 个空格，均匀到 c 个间隙中
     *
     * 目前使用的方法类似于发扑克
     *      重复的遍历间隙
     *      每遍历到一个间隙就给这个间隙分配一个空格。
     *      直到空格分配完毕。
     */
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> rs = new ArrayList<>();
            int l = 0, count = 0;
            for (int i = 0; i < words.length; i ++) {
                if (count + words[i].length() > maxWidth) {
                    justify(words, l, i-1, maxWidth, rs);
                    count = 0;
                    l = i;
                }
                count = count + 1 + words[i].length();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = l; i < words.length; i++) {
                sb.append(words[i]);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            if (sb.length() < maxWidth) {
                appendSpace(sb, maxWidth - sb.length());
            }
            rs.add(sb.toString());
            return rs;
        }

        private void justify(String[] words, int l, int r, int maxWidth, List<String> rs) {
            int c = 0;
            for (int i = l; i <= r; i++) {
                c += words[i].length();
            }
            c = maxWidth - c;
            int s = r - l;
            StringBuilder sb = new StringBuilder(words[l]);
            if (l < r) {
                int[] gap = new int[r-l];
                for (int i = 0; i < c; i++) {
                    gap[i%gap.length] += 1;
                }
                for (int i = l + 1; i <= r; i++) {
                    appendSpace(sb, gap[i]);
                    sb.append(words[i]);
                }
            } else {
                appendSpace(sb, c);
            }
            rs.add(sb.toString());
        }

        private StringBuilder appendSpace(StringBuilder sb, int c) {
            for (int i = 0; i < c; i++) {
                sb.append(' ');
            }
            return sb;
        }

    }

    public static void main(String[] args) {
        String[] words = {
                "What","must","be","acknowledgment","shall","be"
        };
        int maxWidth = 16;
        Out.p(new Solution().fullJustify(words, maxWidth));
    }
}
