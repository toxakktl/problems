package leetcode.arrays.easy;

public class P766_ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return false;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i-1][j-1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}
