package com.dagou.hanoi;

import org.springframework.stereotype.Service;

/**
 * Created by xzhu on 6/27/2017.
 */
@Service
public class Hanoi {
    int moveCount=0;
    public void getNum(int num){
        Pillar source=new Pillar(PillarType.SOURCE);
        Pillar destination=new Pillar(PillarType.DESTINATION);
        Pillar tmp=new Pillar(PillarType.TMP);
        for(int i=0;i<num;i++){
            Reel reel=new Reel(num-i);
            source.getReelList().add(reel);
        }
        System.out.println(source+"-"+destination+"-"+tmp);
        run(num, source, destination, tmp);
        System.out.println("From " + source + " to " + "destination " + "use steps is:" + moveCount);
        System.out.println(source+" "+tmp+" "+destination);
    }
    private void run(int num, Pillar source, Pillar destination, Pillar tmp){
        moveCount++;
        if (num == 1){
            move(source, destination);
        }else{
            run(num - 1, source, tmp, destination);
            move(source, destination);
            run(num - 1, tmp, destination, source);
        }


//
//        moveCount++;
//        destination.getReelList().push(source.getReelList().pop());
//        if(num==1){
////            destination.getReelList().push(source.getReelList().pop());
//            System.out.println(source+"-"+destination+"-"+tmp);
//        }else {
////            tmp.getReelList().push(source.getReelList().pop());
////            destination.getReelList().push(source.getReelList().pop());
////            destination.getReelList().push(tmp.getReelList().pop());
//            run(num-1,source,tmp,destination);
//            run(num-1,tmp,source,destination);
//            System.out.println(source+"-"+destination+"-"+tmp);
//        }
    }

    private void move( Pillar source, Pillar target){
        System.out.println("run Pillar:"+source.getType()+"'s last one["+source.getReelList().getLast().getSize()+"] to "+target.getType());
        target.getReelList().add(source.getReelList().removeLast());




    }
}
