package com.samwei12.array;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/17 5:44 PM
 */
public class Solution977Test {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void sortedSquares() {
        int[] a = {-4,-1,0,3,10};
        final int[] b = new Solution977().sortedSquares(a);
        System.out.println(Arrays.toString(b));
    }
}