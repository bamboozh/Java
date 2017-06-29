package com.dagou.hanoi;

import java.util.LinkedList;

/**
 * Created by xzhu on 6/28/2017.
 */
public class Pillar {
    private PillarType type;
    private LinkedList<Reel> reelList =new LinkedList<>();
    public Pillar( PillarType type){
        this.type=type;
    }
    public PillarType getType() {
        return type;
    }

    public LinkedList<Reel> getReelList() {
        return reelList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(Reel key : reelList){
            stringBuilder.append(key);
        }
        return type+"--"+stringBuilder;
    }
    public void print(Pillar a, Pillar b, Pillar c){
        StringBuilder stringBuilder=new StringBuilder();
        for(Reel key : reelList){
            stringBuilder.append(key);
        }
        for(int i=0;i<stringBuilder.length();i++)
        System.out.println(stringBuilder.charAt(i));
        }
}
