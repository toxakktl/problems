package leetcode.map_set;

import java.util.*;

public class P347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        int[] resArr = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        while (k > 0) {
            int max = 0;
            int maxKey = 0;
            for (int key: countMap.keySet()) {
                if (countMap.get(key) > max) {
                    max = countMap.get(key);
                    maxKey = key;
                }
            }
            res.add(maxKey);
            countMap.remove(maxKey);
            k--;
        }
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(countMap.entrySet());

        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static List<Integer> topKFrequent3(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        topKFrequent3(new int[]{1,1,1,2,2,3}, 2);
    }
}
