package com.dagou;

/**
 * Created by xzhu on 6/28/2017.
 */
public class Reel {
private int num;

    public int getNum() {
        return num;
    }
    public Reel(int num){
        this.num=num;
    }
    public void init(Pillar source,Pillar destination,Pillar tmp){
        Reel reel=source.getReelStack().pop();
    }
}
