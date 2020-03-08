package com.ray.leetcode.resolved;

import com.ray.io.Out;
import com.ray.leetcode.util.graph.Node;

import java.util.*;

/**
 * Clone Graph
 * -----------------------------------------------------------------------------
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1，第二个节点值为 2，以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 * Example:
 *      Example 1
 *      Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 *      Output: [[2,4],[1,3],[2,4],[1,3]]
 *      Explanation: There are 4 nodes in the graph.
 *      1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 *      2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *      3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 *      4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *      Example 2
 *      Input: adjList = [[]]
 *      Output: [[]]
 *      Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 *      Example 3
 *      Input: adjList = []
 *      Output: []
 *      Explanation: This an empty graph, it does not have any nodes.
 *      Example 4
 *      Input: adjList = [[2],[1]]
 *      Output: [[2],[1]]
 *      Constraints:
 *      	1 <= Node.val <= 100
 *      	Node.val is unique for each node.
 *      	Number of Nodes will not exceed 100.
 *      	There is no repeated edges and no self-loops in the graph.
 *      	The Graph is connected and all nodes can be visited starting from the given node.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/clone-graph/
 * @since   2020-03-07 20:04:16
 */
public class L0133_Clone_Graph {
    static class Solution {
        public Node cloneGraph(Node begin) {
            if (begin == null ) return null;
            Map<Integer, Node> cache = new HashMap<>();
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(begin);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                Node newNode = getNode(node.val, cache);
                for (Node n : node.neighbors) {
                    if (!cache.containsKey(n.val)) {
                        queue.offer(n);
                    }
                    newNode.neighbors.add(getNode(n.val, cache));
                }
            }
            return cache.get(begin.val);
        }

        private Node getNode(int val, Map<Integer, Node> cache) {
            if (!cache.containsKey(val)) {
                Node n = new Node();
                n.val = val;
                cache.put(val, n);
            }
            return cache.get(val);
        }
    }

    public static void main(String[] args) {
        Node begin = Node.parse(new int[][]{{2,4},{1,3},{2,4},{1,3}});
        Node node = new Solution().cloneGraph(begin);
        Out.p(begin);
        Out.p(node);
    }
}
