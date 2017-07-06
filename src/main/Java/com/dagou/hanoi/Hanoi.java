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
            print(source, tmp, destination);
        }else{
            run(num - 1, source, tmp, destination);
            move(source, destination);
            print(source, tmp, destination);
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

    public void print(Pillar a, Pillar b, Pillar c) {
        Pillar source = null;
        Pillar tmp = null;
        Pillar destination = null;
        if (a.getType().equals(PillarType.SOURCE)) {
            source = a;
            if (b.getType().equals(PillarType.TMP)) {
                tmp = b;
                destination = c;
            } else {
                tmp = c;
                destination = b;
            }
        }
        if (b.getType().equals(PillarType.SOURCE)) {
            source = b;
            if (b.getType().equals(PillarType.TMP)) {
                tmp = a;
                destination = c;
            } else {
                tmp = c;
                destination = a;
            }
        }
        if (c.getType().equals(PillarType.SOURCE)) {
            source = c;
            if (b.getType().equals(PillarType.TMP)) {
                tmp = b;
                destination = a;
            } else {
                tmp = a;
                destination = b;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string="";
        int length = 0;
        System.out.println(source + "\t" + tmp + "\t" + destination);
        if (source.getReelList().size() > tmp.getReelList().size() && source.getReelList().size() > destination.getReelList().size()) {
            length = source.getReelList().size();
        } else {


            if (tmp.getReelList().size() > source.getReelList().size() && tmp.getReelList().size() > destination.getReelList().size()) {
                length = tmp.getReelList().size();
            } else {
                length = destination.getReelList().size();
            }
        }

        for (int index = 0; index < length; index++) {
            String innerString="";

            if (source.getReelList().size() -1 >= index) {
                innerString += source.getReelList().get(index).getSize() + "\t";
                stringBuilder.insert(0, source.getReelList().get(source.getReelList().size() - 1 - index).getSize() + "\t");
            } else {
                innerString+="|\t";
                stringBuilder.append("|\t");

            }
            if (tmp.getReelList().size() - 1 >=index) {
                innerString+= tmp.getReelList().get(index).getSize() + "\t";
                stringBuilder.insert(0, tmp.getReelList().get(tmp.getReelList().size() - 1 - index).getSize() + "\t");
            } else {
                innerString+="|\t";
                stringBuilder.append("|\t");
            }

            if (destination.getReelList().size() - 1  >=index) {
                innerString+=  destination.getReelList().get( index).getSize() + "\t";
                stringBuilder.insert(0, destination.getReelList().get(destination.getReelList().size() - 1 - index).getSize() + "\t");
            } else {
                innerString+= "|\t";
                stringBuilder.append("|\t");
            }
            string =innerString+"\n"+string;
            stringBuilder.append("\n");

        }
        System.out.println(string);
        System.out.println(stringBuilder.toString());
        }
}
