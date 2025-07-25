package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class StatsFunctionsTest {

    StatsWithLoops loop = new StatsWithLoops();
    StatsWithStreams stream = new StatsWithStreams();
    StreamTransformations transform = new StreamTransformations();

    int[] standard = {3, 1, 4, 1, 5, 9, 2}; // Sum = 25, Avg = 3
    int[] allEvens = {2, 4, 6, 8};
    int[] allOdds = {1, 3, 5, 7};
    int[] negatives = {-5, -2, -9, -1};
    int[] empty = {};

    // ---------- Standard tests ----------
    @Test
    void testForLoopCalculations() {
        assertEquals(9, loop.maximumUsingForLoop(standard));
        assertEquals(1, loop.minimumUsingForLoop(standard));
        assertEquals(25, loop.sumUsingForLoop(standard));
        assertEquals(3, loop.averageUsingForLoop(standard));
    }

    @Test
    void testStreamCalculations() {
        assertEquals(9, stream.maximumUsingStream(standard));
        assertEquals(1, stream.minimumUsingStream(standard));
        assertEquals(25, stream.sumUsingStream(standard));
        assertEquals(3, stream.averageUsingStream(standard));
    }

    // ---------- Edge case: negatives ----------
    @Test
    void testNegativeNumbers() {
        assertEquals(-1, loop.maximumUsingForLoop(negatives));
        assertEquals(-9, loop.minimumUsingForLoop(negatives));
        assertEquals(-17, loop.sumUsingForLoop(negatives));
        assertEquals(-4, loop.averageUsingForLoop(negatives));

        assertEquals(-1, stream.maximumUsingStream(negatives));
        assertEquals(-9, stream.minimumUsingStream(negatives));
        assertEquals(-17, stream.sumUsingStream(negatives));
        assertEquals(-4, stream.averageUsingStream(negatives));
    }

    // ---------- Edge case: empty array ----------
    @Test
    void testEmptyArrayBehavior() {
        assertEquals(0, loop.averageUsingForLoop(empty));
        assertEquals(0, stream.averageUsingStream(empty));

        // For sum, Java Streams will return 0; for max/min, we expect an exception
        assertEquals(0, stream.sumUsingStream(empty));

        assertThrows(java.util.NoSuchElementException.class, () -> stream.maximumUsingStream(empty));
        assertThrows(java.util.NoSuchElementException.class, () -> stream.minimumUsingStream(empty));
    }

    // ---------- Stream transformations ----------
    @Test
    void testEvensOnly() {
        assertArrayEquals(new int[]{4, 2}, transform.evensOnly(standard));
        assertArrayEquals(new int[]{2, 4, 6, 8}, transform.evensOnly(allEvens));
        assertArrayEquals(new int[]{}, transform.evensOnly(allOdds));
    }

    @Test
    void testOddsOnly() {
        assertArrayEquals(new int[]{3, 1, 1, 5, 9}, transform.oddsOnly(standard));
        assertArrayEquals(new int[]{1, 3, 5, 7}, transform.oddsOnly(allOdds));
        assertArrayEquals(new int[]{}, transform.oddsOnly(allEvens));
    }

    @Test
    void testAddFive() {
        assertArrayEquals(new int[]{8, 6, 9, 6, 10, 14, 7}, transform.addFive(standard));
        assertArrayEquals(new int[]{10, 12, 14, 16}, transform.addFive(allEvens));
    }

    @Test
    void testSquareNumbers() {
        assertArrayEquals(new int[]{9, 1, 16, 1, 25, 81, 4}, transform.squareNumbers(standard));
        assertArrayEquals(new int[]{4, 16, 36, 64}, transform.squareNumbers(allEvens));
    }
}
