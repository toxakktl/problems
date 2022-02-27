package leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class P739_DailyTemperatures {

    public int[] dailyTemperatures1(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int currentTemp = temperatures[i];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                res[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73});
    }
}
