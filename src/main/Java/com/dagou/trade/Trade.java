package com.dagou.trade;

import org.springframework.stereotype.Service;

/**
 * Created by bobo on 2017/7/6.
 */
@Service
public class Trade {
    Fund fund = new Fund();

    public void getFund(String name, float price, float purchaseMoney) {
        name = fund.getName();
        price = fund.getFundPrice();
        purchaseMoney = fund.getPurchaseMoney();

    }
}
