class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        for (int i = Math.min(l1, l2); i > 0; i--) {
            if (l1 % i == 0 && l2 % i == 0) {
                String gcd = str1.substring(0, i);
                if (gcd.repeat(l1 / i).equals(str1) && gcd.repeat(l2 / i).equals(str2))
                    return gcd;
            }
        }
        return "";
    }
}