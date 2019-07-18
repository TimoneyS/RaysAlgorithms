package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ray.LintCode.util.Document;
import com.ray.LintCode.util.OutputCollector;

/**
 * 描述：
 *      Use map reduce to build inverted index for given documents.
 *
 * 用例：
 *      
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/inverted-index-map-reduce/description
 * @date   2019-07-11 18:33:38
 */
public class L_0504_Inverted_Index_Map_Reduce {

    static class InvertedIndex {

        public static class Map {
            public void map(String s, Document value,
                            OutputCollector<String, Integer> output) {
                String[] splited = value.content.split("\\s+");
                for (int i = 0; i < splited.length; i++) {
                    output.collect(splited[i], value.id);
                }
            }
        }

        public static class Reduce {
            public void reduce(String key, Iterator<Integer> values,
                               OutputCollector<String, List<Integer>> output) {
                List<Integer> indices = new ArrayList<>();
                while (values.hasNext()) {
                    int curr = values.next();
                    if (indices.isEmpty() || indices.get(indices.size() - 1) != curr) {
                        indices.add(curr);
                    }
                }
                output.collect(key, indices);
            }
        }
    }
    
    public static void main(String[] args) {
        
    }

}
