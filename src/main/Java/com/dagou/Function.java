package com.dagou;

import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2017/6/18.
 */
@Service
public class Function {
    public String Say(String word){
        return "Hello"+word;
    }
}
