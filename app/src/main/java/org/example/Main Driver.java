package org.example;

import java.util.Arrays;

public class MainDriver {
    public static void main(String[] args) {
        int[] sample = {3, 1, 4, 1, 5, 9, 2};

        StatsWithLoops loops = new StatsWithLoops();
        StatsWithStreams streams = new StatsWithStreams();
        StreamTransformations transforms = new StreamTransformations();

        System.out.println("=== Loop-based calculations ===");
        System.out.println("Max (loop): " + loops.maximumUsingForLoop(sample));
        System.out.println("Min (loop): " + loops.minimumUsingForLoop(sample));
        System.out.println("Sum (loop): " + loops.sumUsingForLoop(sample));
        System.out.println("Avg (loop): " + loops.averageUsingForLoop(sample));

        System.out.println("\n=== Stream-based calculations ===");
        System.out.println("Max (stream): " + streams.maximumUsingStream(sample));
        System.out.println("Min (stream): " + streams.minimumUsingStream(sample));
        System.out.println("Sum (stream): " + streams.sumUsingStream(sample));
        System.out.println("Avg (stream): " + streams.averageUsingStream(sample));

        System.out.println("\n=== Stream transformations ===");
        System.out.println("Evens only: " + Arrays.toString(transforms.evensOnly(sample)));
        System.out.println("Odds only: " + Arrays.toString(transforms.oddsOnly(sample)));
        System.out.println("Add five: " + Arrays.toString(transforms.addFive(sample)));
        System.out.println("Squared: " + Arrays.toString(transforms.squareNumbers(sample)));
    }
}
