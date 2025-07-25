package org.example;

import java.util.Arrays;

public class StatsWithStreams {

    public int maximumUsingStream(int[] nums) {
        return Arrays.stream(nums).max().orElseThrow();
    }

    public int minimumUsingStream(int[] nums) {
        return Arrays.stream(nums).min().orElseThrow();
    }

    public int sumUsingStream(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public int averageUsingStream(int[] nums) {
        return (int) Arrays.stream(nums).average().orElse(0);
    }
}
