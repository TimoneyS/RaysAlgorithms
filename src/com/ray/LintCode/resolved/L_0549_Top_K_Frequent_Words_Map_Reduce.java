package com.ray.LintCode.resolved;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import com.ray.LintCode.util.Document;
import com.ray.LintCode.util.OutputCollector;

/**
 *
 *Find top k frequent words with map reduce framework.

The mapper's key is the document id, value is the content of the document, words in a document are split by spaces.

For reducer, the output should be at most k key-value pairs, which are the top k words and their frequencies in this reducer. The judge will take care about how to merge different reducers' results to get the global top k frequent words, so you don't need to care about that part.

The k is given in the constructor of TopK class.
 *
 *Example
Given document A =

lintcode is the best online judge
I love lintcode
and document B =

lintcode is an online judge for coding interview
you can test your code online at lintcode
The top 2 words and their frequencies should be

lintcode, 4
online, 3
 *
 * @author rays1
 *
 */
public class L_0549_Top_K_Frequent_Words_Map_Reduce {

    
    /**
     * map reduce 主要是一种思想，代码实际复杂度不高，这里没有研究，直接粘贴标准答案
     * 以后研究
     * @author rays1
     *
     */
    static class Node {
        String word;
        int count;
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    static class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.count == b.count) {
                return b.word.compareTo(a.word);
            }
            return a.count - b.count;
        }
    }
    
    public static class TopKFrequentWords {

        public static class Map {
            public void map(String s, Document value,
                            OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
                String content = value.content;
                String[] words = content.trim().split("\\s+");
                for (String word : words) {
                    output.collect(word, 1);
                }
            }
        }

        public static class Reduce {
            int k;
            PriorityQueue<Node> minHeap;

            public void setup(int k) {
                // initialize your data structure here
                this.k = k;
                minHeap = new PriorityQueue<>(k + 1, new NodeComparator());
            }   

            public void reduce(String key, Iterator<Integer> values) {
                // Write your code here
                int sum = 0;
                while (values.hasNext()) {
                    sum += values.next();
                }
                minHeap.offer(new Node(key, sum));
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            public void cleanup(OutputCollector<String, Integer> output) {
                // Output the top k pairs <word, times> into output buffer.
                // Ps. output.collect(String key, Integer value);
                List<Node> result = new ArrayList<>();
                while (!minHeap.isEmpty()) {
                    Node node = minHeap.poll();
                    result.add(node);
                }
                for (int i = result.size() - 1; i >= 0; i--) {
                    output.collect(result.get(i).word, result.get(i).count);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
    }

}
