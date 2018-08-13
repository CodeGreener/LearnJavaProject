package com.jj.learn;

import org.junit.jupiter.api.BeforeEach;
import com.jj.learn.leetcode.FindMaxArea11;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxArea11Test {
    FindMaxArea11 inst = null;

    @BeforeEach
    public void init() {
        inst = new FindMaxArea11();
    }

    @Test
    public void test1() {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int max = inst.calc(input);
        int max2 = inst.calcFast(input);
        assertEquals(49, max);
        assertEquals(49, max2);
    }
}
