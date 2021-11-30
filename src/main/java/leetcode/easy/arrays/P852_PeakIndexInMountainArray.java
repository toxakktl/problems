package leetcode.easy.arrays;

public class P852_PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int peak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[peak]){
                peak = i;
            } else {
                return peak;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] < arr[mid+1]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
