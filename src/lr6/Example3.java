package lr6;

public class Example3 {

    static int max(int... nums) {
        int m = nums[0];
        for (int x : nums)
            if (x > m) m = x;
        return m;
    }

    static int min(int... nums) {
        int m = nums[0];
        for (int x : nums)
            if (x < m) m = x;
        return m;
    }

    static double avg(int... nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        return (double) sum / nums.length;
    }
}
