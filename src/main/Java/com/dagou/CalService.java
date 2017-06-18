package com.dagou;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/6/18.
 */
@Service
public class CalService {
    public List<Integer> cal(int length){
       List<Integer> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            result.add(fibonacci(i));
        }
        return result;
    }
    public int fibonacci(int length){
        if(length<2){
            return 1;
        }
        else
        return fibonacci(length - 1)+ fibonacci(length - 2);
    }
}
