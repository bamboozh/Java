package com.dagou;

import org.springframework.stereotype.Service;

/**
 * Created by xzhu on 6/27/2017.
 */
@Service
public class Hanoi {
    int moveCount=0;
    public void getNum(int num){
       char source='A';
        char destination='B';
        char tmp='C';
        move(num,source,destination,tmp);
        System.out.println("From "+source+" to "+ "destination "+"use steps is:"+moveCount);
    }
    private void move(int num,char source , char destination, char tmp){
        moveCount++;
        if(num==1){
            System.out.println("Move from "+source+" to "+destination);
        }else {
            move(num-1,source,tmp,destination);
            move(num-1,tmp,source,destination);
            System.out.println("Move from "+source+" to "+destination);
        }
    }
}
