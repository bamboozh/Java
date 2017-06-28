package com.dagou.hanoi;

/**
 * Created by xzhu on 6/28/2017.
 */
public class Reel {
private int size;

    public int getSize() {
        return size;
    }
    public Reel(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
