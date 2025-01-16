class MyCircularQueue {

    int capacity;
    int size;
    Node front; // dequeue
    Node rear; // enqueue

    class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){ 
            this.val = val;
        }
    }

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.front = new  Node(-1);
        this.rear  = new Node(-1);
        this.rear.next = this.front;
        this.front.prev = this.rear;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity)
            return false;
        Node node = new Node(value);
        Node next = rear.next;
        rear.next = node;
        node.prev = rear;
        node.next = next;
        next.prev = node;

        size+=1;

        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false; 
        Node node = front.prev;
        Node prev = node.prev;
        prev.next = front;
        front.prev = prev;

        node.next = null;
        node.prev = null;
        size-=1;
        return true;
    }
    
    public int Front() {
        return front.prev.val;
    }
    
    public int Rear() {
        return rear.next.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */