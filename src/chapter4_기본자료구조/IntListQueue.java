package chapter4_기본자료구조;

import java.util.ArrayList;
import java.util.List;

public class IntListQueue {

    class Queue {
        int x;
        int y;

        public Queue(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object q) {
            Queue qe = (Queue) q;
            if(this.x == qe.x && this.y == qe.y)
                return true;
            else
                return false;
        }
    }

    private List<Queue> que;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public IntListQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new ArrayList<Queue>(capacity);
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }

    public int enque(int x, int y) throws OverflowIntQueueException {
        if (num >= capacity)
            throw new OverflowIntQueueException();
        que.add(new Queue(x, y)); 
        num++;
        if (rear == capacity)
            rear = 0;
        
		return num;
        
    }

    public Queue deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        Queue q = que.get(front++); 
        num--;
        if (front == capacity)
            front = 0;
        return q; 
    }

    public Queue peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que.get(front);
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que.get(idx).x == x)
                return idx;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("Queue is Empty");
        else {
            for (int i = 0; i < num; i++) {
                int idx = (i + front) % capacity;
                System.out.print("(" + que.get(idx).x + ", " + que.get(idx).y + ") ");
            }
            System.out.println();
        }
    }
}
