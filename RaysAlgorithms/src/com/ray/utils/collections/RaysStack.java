package com.ray.utils.collections;

public class RaysStack<T> {
    
    Node<T> floor;
    Node<T> top;
    
    public RaysStack() {
        floor = new Node<T>(null, null);
        top = floor;
    }
    
    public void push(T element) {
        Node<T> n = new Node<T>(element, top);
        top = n;
    }
    
    public T pop() {
        T e = null;
        if (!top .equals(floor)) {
            e = top.element;
            top = top.next;
        }
        return e;
    }
    
    private static class Node<T> {
        T element;
        Node<T> next;
        
        public Node(T e, Node<T> n) {
            this.element = e;
            next = n;
        }
        
    }
}
