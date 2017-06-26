package com.dagou.exceptions;

/**
 * Created by bobo on 2017/6/26.
 */
public class IllegalInputsException extends RuntimeException {
    public IllegalInputsException(String input) {
        super("illegal input string:"+input);
    }
}
