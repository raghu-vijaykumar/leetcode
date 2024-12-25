class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!ss.isEmpty()) {
                    ss.pop();
                }
            } else
                ss.push(c);
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!ts.isEmpty()) {
                    ts.pop();
                }
            } else
                ts.push(c);
        }

        if (ss.isEmpty() && ts.isEmpty())
            return true;

        while (!ss.isEmpty() && !ts.isEmpty()) {
            System.out.println(ss.peek() + "=" + ts.peek());
            if (ss.peek() != ts.peek())
                return false;
            ss.pop();
            ts.pop();
        }

        return ss.size() == 0 && ts.size() == 0 ? true : false;

    }
}