package com.dagou;
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
    public Integer dagou(@RequestParam(value="inputArray",required = true) String inputArray,@RequestParam(value = "method",required = true)String method){
        if(method.equals("fineLostByString")){
            return calService.fineLostByString(inputArray);
        }
        if (method.equals("findLostByMap")){
            return calService.findLostByMap(inputArray);
        }
        if(method.equals("findLostByXOR")){
            return calService.findLostByXOR(inputArray);
        }
        if (method.equals("findLostBySort")){
            return calService.findLostBySort(inputArray);
        }
        else {
            return calService.findLostBySet(inputArray);
        }
    }
}
