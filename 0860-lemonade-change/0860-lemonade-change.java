class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) {
            if (bill == 5)
                fives++;
            else if (bill == 10) {
                fives--;
                tens++;
                if (fives < 0)
                    return false;
            } else {
                boolean hasChange = true;
                if (tens >= 1) {
                    tens--;
                    if (fives >= 1)
                        fives--;
                    else
                        hasChange = false;
                } else {
                    hasChange = false;
                }
                if (!hasChange && fives >= 3) {
                    fives -= 3;
                } else if (!hasChange) {
                    return false;
                }
            }
        }
        return true;
    }
}