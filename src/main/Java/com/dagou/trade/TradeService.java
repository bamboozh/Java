package com.dagou.trade;

import com.dagou.exceptions.IllegalInputsException;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/7/6.
 */
@Service
public class TradeService {
    List<Trade> tradeRecord;

    @Value("${project.trade.savelocation}")
    private String saveLocation;


    @PostConstruct
    private void init() throws IOException {
        File file = new File(saveLocation);
        if (file.exists()) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                tradeRecord = (List<Trade>) objectInputStream.readObject();
                objectInputStream.close();
            } catch (Exception e) {
                tradeRecord = new ArrayList<>();
            }
        } else {
            tradeRecord = new ArrayList<>();
        }
    }

    public void trade(float price, float purchaseMoney) throws IOException {
        Trade trade = new Trade(price, purchaseMoney);
        tradeRecord.add(trade);
        serializeTradeRecord();
    }

    private void serializeTradeRecord() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(saveLocation)));
        objectOutputStream.writeObject(tradeRecord);
        objectOutputStream.close();
    }
    private float getAmount() {
        float amountSum = 0;
        for (Trade i : tradeRecord) {
            amountSum += i.getAmount();
        }
        return amountSum;
    }
    private float getPurchaseMoney(){
        float purchaseMoneySum=0;
        for(Trade i:tradeRecord){
            purchaseMoneySum+=i.getPurchaseMoney();
        }
        return purchaseMoneySum;
    }
    public float calProfit(float price) {
        float profit;
        profit = getAmount() * price - getPurchaseMoney();
        return profit;
    }

    public float calBEP(float price, float BEP) {
        float profit = calProfit(price);
        float purchaseMoney;
        if (profit >= 0f) {
            return getPurchaseMoney();
        } else {
            purchaseMoney = (getAmount()*BEP-getPurchaseMoney())/price-BEP;
        }
        return purchaseMoney;
    }
    public float sell(float price, float amount)throws IllegalInputsException{
        if(getAmount()-amount<0){
            throw new IllegalInputsException("Illegal input");
        }
        return price*amount;
    }
}
