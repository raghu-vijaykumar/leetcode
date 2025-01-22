class Solution {
    public String replaceDigits(String s) {
        char[] c = s.toCharArray();
        for(int i = 1;i< s.length();i+=2) {
            c[i] = (char) (c[i-1] + c[i] - '0');
        }

        return String.valueOf(c);
    }
}