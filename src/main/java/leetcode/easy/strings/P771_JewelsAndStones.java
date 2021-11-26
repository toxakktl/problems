package leetcode.easy.strings;

public class P771_JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char c: stones.toCharArray()){
            if (jewels.indexOf(c) != -1)
                count++;
        }
        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int[] cnt = new int[128];
        for (char c: stones.toCharArray()){
            cnt[c]++;
        }
        int ans = 0;
        for (char c: jewels.toCharArray()) {
            ans += cnt[c];
        }
        return ans;
    }
}
