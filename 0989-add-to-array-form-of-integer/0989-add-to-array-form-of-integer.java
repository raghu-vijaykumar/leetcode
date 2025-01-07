class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + k % 10 + carry;
            carry = sum / 10;
            num[i] = sum % 10;
            k /= 10;
        }
        List<Integer> result = new ArrayList<>(Arrays.stream(num).boxed().toList());

        while (k > 0) {
            int sum = k % 10 + carry;
            carry = sum / 10;
            result.add(0, sum % 10);
            k /= 10;
        }

        if (carry == 1)
            result.add(0, carry);

        return result;
    }
}