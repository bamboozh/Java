package com.dagou;

import com.dagou.exceptions.IllegalInputsException;
import com.dagou.exceptions.MyCheckedException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


/**
 * Created by bobo on 2017/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalServiceTest {
    @Autowired
    private CalService calService;

    @Test
    public void testCalService() throws Exception {
        List<Integer> testResult=calService.cal(5);
        Assert.assertThat(testResult.get(0),is(1));
        Assert.assertThat(testResult.get(1),is(1));
        Assert.assertThat(testResult.get(2),is(2));
        Assert.assertThat(testResult.get(3),is(3));
        Assert.assertThat(testResult.get(4),is(5));
        Assert.assertThat(testResult.size(), is(5));

    }


    @Test
    public void test_find_the_lost_number() throws Exception {
        int[] input = {1, 2, 3, 3, 2,};
        Assert.assertThat(calService.findLostBySort(input),is(1));

    }

    @Test
    public void test_findLost() throws Exception {
        int[] input={1,4,5,1,4,5,6};
        Assert.assertThat(calService.findLostByMap(input),is(6));
    }

    @Test
    public void test_findLostBySet() throws Exception {
        int[] input={1,4,5,1,4,5,6,7,7};
        Assert.assertThat(calService.findLostBySet(input),is(6));
    }

    @Test
    public void test_find_lost_by_xor() throws Exception {
        int[] input={1,4,5,1,4,5,6,7,7};
        Assert.assertThat(calService.findLostByXOR(input),is(6));

    }

    @Test
    public void test_find_lost_from_string() throws Exception {
        String input = "1,2,3,4,5,6,1,2,3,5,6,s";
        Assert.assertThat(calService.fineLostByString(input),is(4));

    }

    @Test
    public void test_reverse_string() throws Exception {
        Assert.assertThat(calService.reverse("abcd"),is("dcba"));
    }

    @Test
    public void testReverseByString() throws Exception {
        Assert.assertThat(calService.reverseByString("abcd"),is("dcba"));
    }

    @Test
    public void test_catch_exception_1() throws MyCheckedException {
        calService.throwMyException();
    }

    @Test
    public void test_catch_exception_2()  {
        calService.throwMyRTException();
    }


    @Test(expected = IllegalInputsException.class)
    public void test_throw_exception() throws Exception {
        calService.findLostBySet("a,1,c,b");
    }

    @Test(expected = IllegalInputsException.class)
    public void test_throw_exception_2() throws Exception {
        calService.findLostBySet("1,1,2,2");
    }
    @Test(expected = IllegalInputsException.class)
    public void test_throw_exception_3() throws Exception {
        calService.findLostBySet("1,1,2,2,3,4,,,");
    }
}