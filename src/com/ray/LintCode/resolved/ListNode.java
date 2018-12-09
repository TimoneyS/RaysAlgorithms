package com.ray.LintCode.resolved;

import java.util.Scanner;

import com.ray.io.Out;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
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
    
    public static ListNode generate(String str) {
        Scanner sc = new Scanner(str);
        sc.useDelimiter("[,\\{\\}]");
        ListNode pile = new ListNode(-1);
        ListNode n = pile;
        while (sc.hasNextInt()) {
            n.next = new ListNode(sc.nextInt());
            n = n.next;
        }
        sc.close();
        return pile.next;
    }
    
    public static void main(String[] args) {
        ListNode head = ListNode.generate("{1,2,3,4,5,6}");
        
        ListNode.show(head);
    }
    
}
