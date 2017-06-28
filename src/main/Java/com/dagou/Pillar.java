package com.dagou;

import java.util.Stack;

/**
 * Created by xzhu on 6/28/2017.
 */
public class Pillar {
    private int num;
    private String name;
    private Stack<Reel> reelStack=new Stack<>();
    public Pillar(int num, String name){
        this.num=num;
        this.name=name;
    }
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public Stack<Reel> getReelStack() {
        return reelStack;
    }
}
