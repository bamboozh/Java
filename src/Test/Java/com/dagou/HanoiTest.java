package com.dagou;

import com.dagou.hanoi.Hanoi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xzhu on 6/27/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HanoiTest {
    @Autowired
    private Hanoi hanoi;

    @Test
    public void test_Hanoi() throws Exception {
        hanoi.getNum(3);
    }
}
