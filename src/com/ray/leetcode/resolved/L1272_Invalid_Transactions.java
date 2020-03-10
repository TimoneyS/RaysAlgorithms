package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.*;

/**
 * Invalid Transactions
 * -----------------------------------------------------------------------------
 * A transaction is possibly invalid if:
 * 	the amount exceeds $1000, or;
 * 	if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
 *
 * Example:
 *      Example 1
 *      Input: transactions = [alice,20,800,mtv,alice,50,100,beijing]
 *      Output: [alice,20,800,mtv,alice,50,100,beijing]
 *      Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
 *      Example 2
 *      Input: transactions = [alice,20,800,mtv,alice,50,1200,mtv]
 *      Output: [alice,50,1200,mtv]
 *      Example 3
 *      Input: transactions = [alice,20,800,mtv,bob,50,1200,mtv]
 *      Output: [bob,50,1200,mtv]
 *      Constraints:
 *      	transactions.length <= 1000
 *      	Each transactions[i] takes the form {name},{time},{amount},{city}
 *      	Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 *      	Each {time} consist of digits, and represent an integer between 0 and 1000.
 *      	Each {amount} consist of digits, and represent an integer between 0 and 2000.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/invalid-transactions/
 * @since   2020-03-11 00:10:39
 */
public class L1272_Invalid_Transactions {
    /**
     * 主要思路就是将所有在60分钟段内的交易按照name和city分组
     * 如果一个name存在多个city的记录，则这些交易全部是无效的
     * 然后当下一个交易过来时，将这些时间段内，和新交易差距超过60分钟的删除，
     * 然后循环
     */
    static class Solution {
        public List<String> invalidTransactions(String[] transactions) {

            Queue<Tran> pq = new PriorityQueue<>((t1, t2) -> {
                if (t1.name.equals(t2.name)) {
                    return Integer.compare(t1.time, t2.time);
                } else {
                    return t1.name.compareTo(t2.name);
                }
            });

            for (int i = 0; i < transactions.length; i++) {
                String[] a = transactions[i].split(",");
                pq.add(new Tran(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]), a[3], i));
            }

            boolean[] invalid = new boolean[transactions.length];
            Map<String, Queue<Tran>> map = new HashMap<>();
            String name = null;
            int count = 0;
            while (!pq.isEmpty()) {
                Tran t = pq.poll();
                if (name == null || !name.equals(t.name)) {
                    name = t.name;
                    map.clear();
                    count = 0;
                }

                if (t.amount > 1000) {
                    invalid[t.index] = true;
                }

                if (!map.containsKey(t.city)) {
                    map.put(t.city, new ArrayDeque<>());
                }
                if (map.get(t.city).size() == 0) {
                    count ++;
                }
                map.get(t.city).add(t);
                for (Queue<Tran> q : map.values()) {
                    if (q.isEmpty()) continue;
                    while (!q.isEmpty() && q.peek().time < t.time - 60) {
                        q.poll();
                    }
                    if (q.isEmpty()) count --;
                }
                if (count > 1) {
                    for (Queue<Tran> q : map.values()) {
                        for (Tran tt : q)
                            invalid[tt.index] = true;
                    }
                }
            }

            List<String> rs = new ArrayList<>();
            for (int i = 0; i < invalid.length; i++) {
                if (invalid[i]) {
                    rs.add(transactions[i]);
                }
            }
            return rs;
        }

        class Tran {
            String name;
            String city;
            int time;
            int amount;
            int index;

            public Tran(String name, int time, int amount, String city, int index) {
                this.name = name;
                this.city = city;
                this.time = time;
                this.amount = amount;
                this.index = index;
            }
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
