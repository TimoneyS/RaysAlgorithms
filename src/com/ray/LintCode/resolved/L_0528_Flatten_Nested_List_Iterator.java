package com.ray.LintCode.resolved;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.ray.LintCode.util.NestedInteger;
import com.ray.io.Out;

/**
 *
 *
 * @author rays1
 *
 */
public class L_0528_Flatten_Nested_List_Iterator {

    static class NestedIterator implements Iterator<Integer> {

        class Pair {
            List<NestedInteger> list;
            int index;
            public Pair(List<NestedInteger> list, int index) {
                super();
                this.list = list;
                this.index = index;
            }
            public boolean isValid() {
                return index < list.size();
            }
            public NestedInteger curr() {
                return list.get(index);
            }
        }
        
        Stack<Pair>  stack;
        
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(new Pair(nestedList, 0));
            insureNext();
        }
        
        /**
         * 保证调用next时，栈顶的一定是数字
         */
        private void insureNext() {
            while (!stack.isEmpty()) {
                Pair p = stack.peek();
                NestedInteger ni;
                if (!p.isValid()) {
                    stack.pop();
                } else if ( !(ni = p.curr()).isInteger()) { 
                    p.index ++;
                    stack.push(new Pair(ni.getList(), 0));
                } else {
                    break;
                }
            }
        }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
            Pair p = stack.peek();
            Integer rs = p.curr().getInteger();
            p.index ++;
            insureNext();
            return rs;
        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            return !stack.empty() && stack.peek().isValid();
        }

        @Override
        public void remove() {}
    }
    
    public static void main(String[] args) {
        
        String s = "[[1,2],2,[1,1]]";
        NestedInteger ni = NestedInteger.build(s);
        
        Iterator<Integer> ite = new NestedIterator(ni.getList());
        
        while(ite.hasNext()) {
            Out.pt(ite.next());
        }
        
    }

}
