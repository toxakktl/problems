package leetcode.arrays.medium;

public class P48_RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int N = matrix.length;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = matrix[N-1-j][i];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int N = matrix.length;
        for (int i = 0; i < (N+1)/2; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = temp;
            }
        }
    }

}
