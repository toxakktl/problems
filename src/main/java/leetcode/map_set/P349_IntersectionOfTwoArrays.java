package leetcode.map_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num: nums1){
            set.add(num);
        }
        for (int num: nums2){
            if (set.contains(num))
                res.add(num);
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (int i: res){
            result[index++] = i;
        }
        return result;
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right])
                left++;
            else if (nums1[left] > nums2[right])
                right++;
            else {
                res.add(nums1[left]);
                left++;
                right++;
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (int i: res){
            result[index++] = i;
        }
        return result;
    }
}
