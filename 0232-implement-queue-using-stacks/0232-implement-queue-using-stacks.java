class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack =  new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        int size = stack.size() -1;
        List<Integer> list = new ArrayList<>();
        while(size-- >0) {
            list.add(stack.pop());
        }

        int elem = stack.pop();
        for(int i = list.size() - 1;i>=0;i--) {
            stack.push(list.get(i));
        }
        return elem;
    }
    
    public int peek() {
        int size = stack.size() -1;
        List<Integer> list = new ArrayList<>();
        while(size-- >0) {
            list.add(stack.pop());
        }

        int elem = stack.peek();
        for(int i = list.size() - 1;i>=0;i--) {
            stack.push(list.get(i));
        }
        return elem;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */