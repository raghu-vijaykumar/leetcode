class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                int i = stack.pop();
                int j = stack.peek();
                stack.push(i);
                stack.push(i + j);
            } else {
                stack.push(Integer.parseInt(op));
            }

        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }
}