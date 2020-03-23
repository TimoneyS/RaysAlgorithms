package com.ray.leetcode.util;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    Integer number;
    List<NestedInteger> inner;

    public NestedInteger() {
    }

    public NestedInteger(int value) {
        number = value;
    }

    public boolean isInteger() {
        return inner == null;
    }

    public Integer getInteger() {
        return number;
    }

    public void setInteger(int value) {
        number = value;
    }

    public void add(NestedInteger ni) {
        if (inner == null) inner = new ArrayList<>();
        inner.add(ni);
    }

    public List<NestedInteger> getList() {
        return inner;
    }
}