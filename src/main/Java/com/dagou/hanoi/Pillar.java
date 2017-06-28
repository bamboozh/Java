package com.dagou.hanoi;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xzhu on 6/28/2017.
 */
public class Pillar {
    private PillarType type;
    private LinkedList<Reel> reelStack=new LinkedList<>();
    public Pillar( PillarType type){
        this.type=type;
    }
    public PillarType getType() {
        return type;
    }

    public LinkedList<Reel> getReelStack() {
        return reelStack;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(Reel key :reelStack){
            stringBuilder.append(key);
        }
        return type+"--"+stringBuilder;
    }
}
