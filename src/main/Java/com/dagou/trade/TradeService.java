package com.dagou.trade;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/7/6.
 */
@Service
public class TradeService {
    List<Trade> tradeRecord = new ArrayList<>();

    public void trade(float price, float purchaseMoney) {
        Trade trade = new Trade(price, purchaseMoney);
        tradeRecord.add(trade);
    }

    public float calProfit(float price) {
        float amountSum = 0;
        float purchaseMoneySum = 0;
        float profit;
        for (Trade i : tradeRecord) {
            amountSum += i.getAmount();
            purchaseMoneySum += i.getPurchaseMoney();
        }
        profit = amountSum * price - purchaseMoneySum;
        return profit;
    }

    public float calBEP(float price, float BEP) {
        float purchaseMoney = 0;
        float profit = calProfit(price);
        if (profit >= 0f) {
            return purchaseMoney;
        } else {
            float amountSum = 0;
            float purchaseMoneySum = 0;
            float amount=0;
            for (Trade i : tradeRecord) {
                amountSum += i.getAmount();
            }
            purchaseMoney=(amountSum+amount)*BEP-purchaseMoneySum;
        }
        return purchaseMoney;
    }
}
