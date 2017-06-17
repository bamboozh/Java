package com.dagou;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bobo on 2017/6/17.
 */
@Controller
public class Hello {
    @RequestMapping("/")
    public String HomePage(@RequestParam(value="name",required = false,defaultValue = "Dagou") String name, Model model){
        model.addAttribute("name",name);
        return "HomePage";
    }
    @RequestMapping("/u")
    public String hello(@RequestParam(value="name", required=false, defaultValue="Dagou") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }
}
