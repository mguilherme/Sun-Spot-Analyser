package com.guilherme.miguel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Miguel Guilherme
 */
public class TestCase {

    /**
     * 3x3 Grid with t=1
     */
    @Test
    public void test1() {
        String expected = "(1,1 score:20)";
        SunSpot sunSpot = new SunSpot(1, 3, 4, 2, 3, 2, 2, 1, 3, 2, 1);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 3x3 Grid with t=2
     */
    @Test
    public void test2() {
        String expected = "(1,1 score:20) (1,0 score:15)";
        SunSpot sunSpot = new SunSpot(2, 3, 4, 2, 3, 2, 2, 1, 3, 2, 1);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 3x3 Grid with t=3
     */
    @Test
    public void test3() {
        String expected = "(1,1 score:20) (1,0 score:15) (0,1 score:14)";
        SunSpot sunSpot = new SunSpot(3, 3, 4, 2, 3, 2, 2, 1, 3, 2, 1);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 3x3 Grid with t=4
     */
    @Test
    public void test4() {
        String expected = "(1,1 score:20) (1,0 score:15) (0,1 score:14) (2,1 score:11)";
        SunSpot sunSpot = new SunSpot(4, 3, 4, 2, 3, 2, 2, 1, 3, 2, 1);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 5x5 Grid with t=1
     */
    @Test
    public void test5() {
        String expected = "(3,3 score:26)";
        SunSpot sunSpot = new SunSpot(1, 5, 5, 3, 1, 2, 0, 4, 1, 1, 3, 2, 2, 3, 2, 4, 3, 0, 2, 3, 3, 2, 1, 0, 2, 4, 3);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 5x5 Grid with t=5
     */
    @Test
    public void test6() {
        String expected = "(3,3 score:26) (3,2 score:23) (2,2 score:22) (1,2 score:20) (3,4 score:19)";
        SunSpot sunSpot = new SunSpot(5, 5, 5, 3, 1, 2, 0, 4, 1, 1, 3, 2, 2, 3, 2, 4, 3, 0, 2, 3, 3, 2, 1, 0, 2, 4, 3);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 4x4 Grid with t=3
     */
    @Test
    public void test7() {
        // In Test 2 from Test there is an error, (1,2) score should be 18; 3+2+1+4+2+0+4+1+1=18
        // (2,1) score is 27; 4+4+2+3+4+1+2+3+4=27
        String expected = "(2,1 score:27) (1,1 score:25) (2,2 score:23)";
        SunSpot sunSpot = new SunSpot(3, 4, 2, 3, 2, 1, 4, 4, 2, 0, 3, 4, 1, 1, 2, 3, 4, 4);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }

    /**
     * 4x4 Grid with t=4
     */
    @Test
    public void test8() {
        String expected = "(2,1 score:27) (1,1 score:25) (2,2 score:23) (2,0 score:20)";
        SunSpot sunSpot = new SunSpot(4, 4, 2, 3, 2, 1, 4, 4, 2, 0, 3, 4, 1, 1, 2, 3, 4, 4);
        assertThat(sunSpot.analyse(), is(equalTo(expected)));
    }
    
}
