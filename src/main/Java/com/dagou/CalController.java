package com.dagou;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bobo on 2017/6/18.
 */
@RestController
public class CalController {
    @Autowired
    CalService calService;
    @RequestMapping("/cal")
    public List<Integer> calResult(@RequestParam(value="length",required = true)int length){
        return calService.cal(length);
    }
    @RequestMapping("/dagou")
    public Integer Dagou(@RequestParam(value="inputArray",required = true) String inputArray){
        return calService.fineLostByString(inputArray);
    }
}
