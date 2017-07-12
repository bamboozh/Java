package com.dagou.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by bobo on 2017/7/9.
 */
@RestController
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @RequestMapping("/fund")
    public List getRecord(){
       return tradeService.tradeRecord;
    }
    @RequestMapping("/trade")
    public void trade(@RequestParam("price") float price, @RequestParam("tradeMoney") float tradeMoney)throws IOException{
        tradeService.trade(price, tradeMoney);
    }
    @RequestMapping("/calProfit")
    public float getProfit(@RequestParam("price") float price){
        return tradeService.calProfit(price);
    }
    @RequestMapping("/calBEP")
    public  float getBEP(@RequestParam("price") float price,@RequestParam("BEP")float BEP){
        return tradeService.calBEP(price,BEP);
    }
}
