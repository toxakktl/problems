package leetcode.priorityqueue.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P215_KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int i: nums) {
            pq.add(i);
        }
        while (--k > 0) {
            pq.poll();
        }
        return pq.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
