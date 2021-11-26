package leetcode.easy.arrays;

public class P2011_FinalValueofVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op: operations) {
            if (op.equals("--X") || op.equals("X--"))
                res--;
            else
                res++;
        }
        return res;
    }

    public int finalValueAfterOperations2(String[] operations) {
        int res = 0;
        for (String op: operations) {
            if (op.charAt(1) == '-')
                res--;
            else
                res++;
        }
        return res;
    }
}
