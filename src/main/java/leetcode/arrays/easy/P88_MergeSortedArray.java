package leetcode.arrays.easy;

public class P88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 && nums2.length== 0)
            return;
        int[] res = new int[nums1.length];
        int ind = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]){
                res[ind++] = nums1[i++];
            } else {
                res[ind++] = nums2[j++];
            }
        }
        if (i == m) {
            while (j < n)
                res[ind++] = nums2[j++];
        } else if (j == n) {
            while (i < m) {
                res[ind++] = nums1[i++];
            }
        }
        for (int k = 0; k < res.length; k++) {
            nums1[k] = res[k];
        }
    }

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n -1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]){
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge2(nums1, m, nums2, n);
        for (int i =0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
