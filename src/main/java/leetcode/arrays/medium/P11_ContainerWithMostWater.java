package leetcode.arrays.medium;

public class P11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return -1;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length -1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
