class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int pLen = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int sbLen = sb.length();

            if (sbLen >= pLen && sb.substring(sbLen - pLen).equals(part))
                sb.delete(sbLen - pLen, sbLen);
        }

        return sb.toString();

    }
}