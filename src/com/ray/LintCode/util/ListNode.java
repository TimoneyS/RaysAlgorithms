package com.ray.LintCode.util;

import java.util.Random;
import java.util.Scanner;

import com.ray.io.Out;

public class ListNode {
    public static int ID_GEN = 0;
    public int id;
    public int val;
    public ListNode next;

    public ListNode(int x) {
        id = ID_GEN ++;
        val = x;
        next = null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head.next != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        sb.append(head.val);
        return sb.toString();
    }
    
    public static void show(ListNode head) {
        if (head == null) {
            Out.p("{}");
            return;
        }
        Out.p(head.toString());
    }
    
    public ListNode next(int step) {
        ListNode n = this;
        while (step > 0) {
            n = n.next;
            step --;
            if (n == null) break;
        }
        return n;
    }
    
    public ListNode nextVal(int val) {
        ListNode n = this;
        while (n != null) {
            if (n.val == val) break;
            n = n.next;
        }
        return n;
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
    
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof ListNode)) {
            return false;
        } 
        ListNode o1 = this;
        ListNode o2 = (ListNode)obj;
        while (o1 != null && o2 != null) {
            if (o1 == null && o2 != null || o1 != null && o2 == null || o1.val != o2.val) {
                return false;
            }
            o1 = o1.next;
            o2 = o2.next;
        }
        return true;
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

    public void show() {
        ListNode.show(this);
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.parse("{1,2,3,4,5,6}");
        
        ListNode.show(head);
    }
    
}
