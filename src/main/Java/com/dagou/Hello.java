package com.dagou;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bobo on 2017/6/17.
 */
@RestController
@RequestMapping("/a")
public class Hello {
    @RequestMapping("/b")
    public String he(){
        return "Hello,dagou";
    }
}
