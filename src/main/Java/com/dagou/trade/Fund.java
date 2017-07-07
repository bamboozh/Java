package com.dagou.trade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/7/6.
 */
public class Fund {
    private List<Float> fundAmount = new ArrayList<>();
    private float fundPrice;
    private float purchaseMoney;

    public String getName() {
        return name;
    }

    private String name;
    public float getPurchaseMoney() {
        return purchaseMoney;
    }

    public float getFundPrice() {
        return fundPrice;
    }

    public List<Float> getFundAmount() {
        return fundAmount;
    }
}
