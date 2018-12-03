package com.lzq.managements.util.test;

import java.util.Map;


public class Object1 {
    private String name;
    private Map<String,Object2> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object2> getChild() {
        return child;
    }

    public void setChild(Map<String, Object2> child) {
        this.child = child;
    }
}
