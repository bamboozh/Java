package com.dagou.trade;

import java.io.Serializable;

/**
 * Created by bobo on 2017/7/9.
 */
public class Trade implements Serializable{
    private float price;
    private float purchaseMoney;
    private float amount;
    public Trade(float price,float purchaseMoney){
        this.price=price;
        this.purchaseMoney=purchaseMoney;
        amount=purchaseMoney/price;
    }

    public float getAmount() {
        return amount;
    }

    public float getPurchaseMoney() {
        return purchaseMoney;
    }

    public float getPrice() {
        return price;
    }
}
