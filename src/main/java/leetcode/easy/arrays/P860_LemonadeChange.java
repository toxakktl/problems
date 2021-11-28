package leetcode.easy.arrays;

public class P860_LemonadeChange {

    /**
     * dumb solution
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else {
                if (tens == 0) {
                    if (fives < 3) return false;
                    fives -=3;
                } else {
                    if (fives == 0) return false;
                    tens--;
                    fives--;
                }
            }
        }
        return true;
    }
}
