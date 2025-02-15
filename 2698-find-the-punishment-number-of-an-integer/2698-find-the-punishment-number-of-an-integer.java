class Solution {
    public int punishmentNumber(int n) {
        Set<Integer> punishmentNumbers = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            dfs(i * i, punishmentNumbers, 0, i);
            //System.out.println();
        }
        //System.out.println(punishmentNumbers);
        return punishmentNumbers.stream().mapToInt(i -> i * i).sum();
    }

    public void dfs(int n, Set<Integer> nums, int val, int originalNum) {

        // System.out.println("Val: "+ val + " originalNum: "+ originalNum + " N:" + n);
        if (val == originalNum && n == 0) {
            nums.add(originalNum);
            return;
        }
        if (val > originalNum || n == 0)
            return;

        int divisor = 10;
        while (n % divisor != n) {
            dfs(n / divisor, nums, val + n % divisor, originalNum);
            divisor *= 10;
        }
        dfs(n / divisor, nums, val + n % divisor, originalNum);
    }
}