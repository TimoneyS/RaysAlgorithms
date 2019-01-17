package com.ray.LintCode.util;

import static com.ray.io.Out.p;

import com.ray.io.Out;
import com.ray.util.StringUtil;

public class ExpressionTreeNode {
     public String symbol;
     public ExpressionTreeNode left, right;
     public ExpressionTreeNode(String symbol) {
         this.symbol = symbol;
         this.left = this.right = null;
     }
     
     public void show() {
         p("== tree ===========================");
         tree(0, 1);
         p("===================================");
     }

     public void tree(int type, int deepth) {
         if (right != null) right.tree(1, deepth+1);
         String suffix = StringUtil.multiString(' ', deepth * 5);
         if (type == 0) {
             Out.pf("%s--[%s]\n", suffix, symbol);
         } else if (type > 0) {
             Out.pf("%s /[%s]\n", suffix, symbol);
         } else {
             Out.pf("%s \\[%s]\n", suffix, symbol);
         }
         if (left != null) left.tree(-1, deepth+1);
     }
     
 }