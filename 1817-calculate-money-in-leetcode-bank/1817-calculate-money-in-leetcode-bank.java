class Solution {
    public int totalMoney(int n) {
        int start = 1;
        int weeks = n/7;
        int days = n%7;
        int sum = 0;
        for(int i = 0;i< weeks;i++) {
            sum += (start+6+start) * 7 / 2;
            start++;
        }

        for(int i = 0;i< days;i++) {
            sum+=start++;
        }
        return sum;
    }
}