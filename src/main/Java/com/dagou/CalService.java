package com.dagou;

import com.dagou.exceptions.IllegalInputsException;
import com.dagou.exceptions.MyCheckedException;
import com.dagou.exceptions.MyRuntimeException;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                targetMap.put(targetArray[i], value + 1);
            }else {
                targetMap.put(targetArray[i], 1);
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
        }
        if(targetSet.size()==0) {
            throw new IllegalInputsException("input illegal");
        }
        if(targetSet.size()>1){
            throw new IllegalInputsException("not only one");
        }
            for (Integer key : targetSet) {
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
        return findLostBySet(stringToArray(targetArray));
    }
    public int[] stringToArray(String targetArray) {
        int[] getInt;
        try {
            String[] getArray = targetArray.split(",");
            getInt = new int[getArray.length];
            for (int i = 0; i < getArray.length; i++) {
                getInt[i] = Integer.valueOf(getArray[i]);
            }
        } catch (NumberFormatException nf) {
            throw new IllegalInputsException(targetArray);
        }
        return getInt;
    }
    public Integer findLostBySort(String targetArray){
        return findLostBySort(stringToArray(targetArray));
    }
    public Integer findLostByMap(String targetArray){
        return findLostByMap(stringToArray(targetArray));
    }
    public Integer findLostBySet(String targetArray){
        return findLostBySet(stringToArray(targetArray));
    }
    public Integer findLostByXOR(String targetArray){
        return findLostByXOR(stringToArray(targetArray));
    }
    public String reverse(String targetArray){
        String[] getArray=targetArray.split("");
        String tmp;
        String result="";
        for(int i=0;i<getArray.length/2;i++){
            if(getArray[i].equals(getArray[getArray.length-1-i])){
                getArray[i]=getArray[i];
            }else {
                tmp=getArray[i]; // tmp=a;
                getArray[i]=getArray[getArray.length-1-i];//a=c
                getArray[getArray.length-1-i]=tmp;//c=a;
            }
        }
        for(String s:getArray){
            result+=s;
        }
        return result;
    }
    public String reverseByString(String targetArray){
        StringBuilder result=new StringBuilder();
        for(int i=targetArray.length()-1;i>=0;i--){
            result.append(targetArray.charAt(i));
        }
        return String.valueOf(result);
    }

    public void throwMyException() throws MyCheckedException {
        throw new MyCheckedException();
    }

    public void throwMyRTException(){
        throw new MyRuntimeException();
    }
}
