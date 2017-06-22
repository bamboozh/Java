package com.dagou;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by bobo on 2017/6/18.
 */
@Service
public class CalService {
    public List<Integer> cal(int length) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(fibonacci(i));
        }
        return result;
    }

    public int fibonacci(int length) {
        if (length < 2) {
            return 1;
        } else
            return fibonacci(length - 1) + fibonacci(length - 2);
    }


    public Integer findLostBySort(int[] targetArray) {
        Arrays.sort(targetArray);
        for (int i = 0; i < targetArray.length; i += 2) {
            if (i == targetArray.length - 1) {
                return targetArray[i];
            }
            if (targetArray[i] != targetArray[i + 1]) {
                return targetArray[i];
            }
        }
        return null;
    }

    public Integer findLostByMap(int[] targetArray) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < targetArray.length; i++) {
            if(targetMap.containsKey(targetArray[i])){
                int value=targetMap.get(targetArray[i]);
                targetMap.put(targetArray[i],value+1);
            }else {
                targetMap.put(targetArray[i],1);
            }
        }
        for(Integer key :targetMap.keySet()){
            if(targetMap.get(key)==1){
                return key;
            }
        }

        return null;
    }
    public Integer findLostBySet(int[] targetArray){
        Set<Integer> targetSet=new HashSet<>();
        for(int i=0;i<targetArray.length;i++){
            if(targetSet.contains(targetArray[i])){
                targetSet.remove(targetArray[i]);
            }else{
                targetSet.add(targetArray[i]);
            }
        }for (Integer key :targetSet){
            return key;
        }
        return null;
    }

    public Integer findLostByXOR(int[] targetArray){
        int result = 0;
        for (int i : targetArray) {
            result = result^i;
        }
        return result;
    }
    public  Integer fineLostByString(String targetArray){
        String[] getArray= targetArray.split(",");
        int[] getInt=new int[getArray.length];
        for(int i=0;i<getArray.length;i++){
            getInt[i]=Integer.valueOf(getArray[i]);
        }
        return findLostBySet(getInt);
    }
}