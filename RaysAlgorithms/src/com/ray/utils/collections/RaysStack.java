package com.ray.utils.collections;

/**
 * �Զ����ջ����
 * @author rays1
 *
 * @param <T>
 */
public final class RaysStack<T> {
    
    private Node<T> floor;
    private Node<T> top;
    
    public RaysStack() {
        floor = new Node<T>(null, null);
        top = floor;
    }
    
    /**
     * ��ջ
     * @param element
     */
    public void push(T element) {
        Node<T> n = new Node<T>(element, top);
        top = n;
    }
    
    /**
     * ջ�Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty() {
        return top.equals(floor);
    }
    
    /**
     * ��ջ
     * @return
     */
    public T pop() {
        T e = null;
        if (!top .equals(floor)) {
            e = top.element;
            top = top.next;
        }
        return e;
    }
    
    /**
     * ջ�ڵ�
     * @author rays1
     *
     * @param <T>
     */
    private static final class Node<T> {
        T element;
        Node<T> next;
        
        public Node(T e, Node<T> n) {
            this.element = e;
            next = n;
        }
        
    }
}
