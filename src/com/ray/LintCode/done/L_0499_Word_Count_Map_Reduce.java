package com.ray.LintCode.done;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.ray.LintCode.util.OutputCollector;

/**
 * 描述：
 *      Using map reduce to count word frequency.
 *      
 *      https://hadoop.apache.org/docs/r1.2.1/mapred_tutorial.html#Example%3A+WordCount+v1.0
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *          chunk1: "Google Bye GoodBye Hadoop code"
 *          chunk2: "lintcode code Bye"
 *      
 *      Output:
 *          Bye: 2
 *          GoodBye: 1
 *          Google: 1
 *          Hadoop: 1
 *          code: 2
 *          lintcode: 1
 *      ```        
 *      Example 2:
 *      ```
 *      Input:
 *          chunk1: "Lintcode is so so good"
 *      
 *      Output:
 *          Lintcode: 1
 *          good: 1
 *          is: 1
 *          so: 2
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/word-count-map-reduce/description
 * @date   2019-07-11 18:33:32
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
        
        
    }

}
