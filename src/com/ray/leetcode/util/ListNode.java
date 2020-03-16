package com.ray.leetcode.util;

import com.ray.io.Out;

import java.util.Random;
import java.util.Scanner;

public class ListNode {
    public static int ID_GEN = 0;
    public int id;
    public int val;
    public ListNode next;

    public ListNode(int x) {
        id = ID_GEN ++;
        val = x;
    }

    public static ListNode parse(String str) {
        Scanner sc = new Scanner(str);
        sc.useDelimiter("[,{}]");
        ListNode pile = new ListNode(-1);
        ListNode n = pile;
        while (sc.hasNextInt()) {
            n.next = new ListNode(sc.nextInt());
            n = n.next;
        }
        sc.close();
        return pile.next;
    }

    public static ListNode randomList(int size, int high) {
        return randomList(size, 0, high);
    }

    public static ListNode randomList(int size, int low, int high) {
        Random r = new Random(47);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < size; i++) {
            sb.append(r.nextInt(high-low) + low);
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append('}');

        return parse(sb.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) return false;
        for (ListNode o1 = this, o2 = (ListNode)obj; o1 != null || o2 != null; o1 = o1.next, o2 = o2.next)
            if (o1 == null || o2 == null || o1.val != o2.val)
                return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (ListNode node = this; node != null; node = node.next)
            sb.append(node.val).append("->");
        return sb.substring(0, sb.length()-2) + '}';
    }

    public void show() {
        Out.p(toString());
    }

    public static void show(ListNode head) {
        if (head == null) {
            Out.p("{}");
            return;
        }
        head.show();
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3,4,5,6}");
        ListNode.show(head);
    }
}
