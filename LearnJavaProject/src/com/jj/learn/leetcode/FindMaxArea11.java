package com.jj.learn.leetcode;

public class FindMaxArea11 {


    public int calc(int[] input) {
        int max = 0;
        for (int i = 0; i < input.length - 1; i ++) {
            if (input[i] == 0 || (input.length - 1 - i) * input[i] < max) {
                continue;
            }
            int starting = Math.max(i + 1, max / input[i]);
            for (int j = starting; j < input.length; j ++) {
                int height = Math.min(input[i], input[j]);
                int area = (j - i) * height;
                max = Math.max(max, area);
            }
        }

        return max;
    }

    public int calcFast(int[] input) {
        int max = 0;
        int left = 0;
        int right = input.length - 1;
        while ( left < right) {
            int area = (right - left) * Math.min(input[left], input[right]);
            max = Math.max(max, area);

            if (input[left] > input[right]) {
                right --;
            } else {
                left ++;
            }
        }


        return max;
    }
}
