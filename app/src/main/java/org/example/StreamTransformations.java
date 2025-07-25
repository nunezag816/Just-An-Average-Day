package example.org;

import java.util.Arrays;

public class StreamTransformations {

    public int[] evensOnly(int[] nums) {
        return Arrays.stream(nums)
                     .filter(n -> n % 2 == 0)
                     .toArray();
    }

    public int[] oddsOnly(int[] nums) {
        return Arrays.stream(nums)
                     .filter(n -> n % 2 != 0)
                     .toArray();
    }

    public int[] addFive(int[] nums) {
        return Arrays.stream(nums)
                     .map(n -> n + 5)
                     .toArray();
    }

    public int[] squareNumbers(int[] nums) {
        return Arrays.stream(nums)
                     .map(n -> n * n)
                     .toArray();
    }
}
