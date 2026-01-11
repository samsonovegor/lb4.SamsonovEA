package lr6;

public class Example10 {

    static int[] maxMin(int... nums) {
        int max = nums[0];
        int min = nums[0];

        for (int x : nums) {
            if (x > max) max = x;
            if (x < min) min = x;
        }
        return new int[]{max, min};
    }
}
