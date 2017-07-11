package com.dagou;

import com.dagou.trade.TradeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by bobo on 2017/7/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {
    @Autowired
    private TradeService tradeService;

    @Before
    public void setUp() throws Exception {
        tradeService.trade(1f, 100f);
        tradeService.trade(1.3f, 100f);
    }

    @Test
    public void test_TradeService() throws Exception {
        float result=tradeService.calProfit(1.11f);
        System.out.println(result);
        Assert.assertThat(result,is(11.909088f));
    }

    @Test
    public void test_TradeService2() throws Exception {
        float result=tradeService.calBEP(1.11f,1.05f);
        System.out.println(result);
    }
}
