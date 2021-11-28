package leetcode.easy.math;

public class P836_RectangleOverlap {
    /**
     * couldn't solve in an hour...
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || //case when rec1 is to the left of rec2
                rec1[0] >= rec2[2] || // case when rec1 is to the right of rec2
                rec1[1] >= rec2[3] || // case when rec1 is higher than rec2
                rec1[3] <= rec2[1]); //case when rec1 is lower than rec2
    }
}
