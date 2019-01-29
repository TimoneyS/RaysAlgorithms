package com.ray.LintCode.resolved;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.ray.LintCode.util.OutputCollector;
import com.ray.io.Out;

/**
 * 使用 map reduce 统计单词频率
 * 
 * 
 * @author rays1
 *
 */
public class L_0499_Word_Count_Map_Reduce {

    /**
     * map reduce 是数据处理的两个步骤
     * 分别可以说是 收集、 归整
     * 
     * 第一步只是简单的讲数据全部收集起来。
     * 第二步的操作是按照数据的规律将数据重新分配位置。
     * 
     * 这个答案是按照标准解答来的，并非自己写作，只是作为参考。这种题目难度不高，只是作为了解一种思想的入门基础。
     * 
     * @author rays1
     *
     */
    static class WordCount {

        public static class Map {
            public void map(String key, String value, OutputCollector<String, Integer> output) {
                StringTokenizer tokenizer = new StringTokenizer(value);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    output.collect(word, 1);
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<Integer> values,
                               OutputCollector<String, Integer> output) {
                int sum = 0;
                while (values.hasNext()) {
                        sum += values.next();
                }
                output.collect(key, sum);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new WordCount());
        
    }

}
