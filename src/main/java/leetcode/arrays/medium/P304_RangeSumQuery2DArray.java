package leetcode.arrays.medium;

public class P304_RangeSumQuery2DArray {

    int[][] dp;

    public P304_RangeSumQuery2DArray(int[][] matrix) {
        dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }


//    public P304_RangeSumQuery2DArray(int[][] matrix) {
//        dp = new int[matrix.length][matrix[0].length+1];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                dp[i][j+1] = dp[i][j] + matrix[i][j];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            sum += dp[i][col2+1] - dp[i][col1];
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        P304_RangeSumQuery2DArray obj = new P304_RangeSumQuery2DArray(matrix);
        System.out.println(obj.sumRegion(2,1,4,3));
    }

}
