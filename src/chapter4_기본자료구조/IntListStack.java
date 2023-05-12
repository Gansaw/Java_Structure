package chapter4_기본자료구조;

import java.util.ArrayList;
import java.util.List;

class IntListStack {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object p) {
            Point pt = (Point) p;
            if (this.x == pt.x && this.y == pt.y)
                return true;
            else
                return false;
        }
    }

    private List<Point> data; // stack 배열
    private int capacity; // stack 용량
    private int top; // stack 포인터

    // 생성자
    public IntListStack(int maxlen) {
        top = 0;
        capacity = maxlen;
        try {
            data = new ArrayList<Point>(capacity);
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }

    }

    // stack 예외 - empty(비어있음)
    public class EmptyIntListStackException extends RuntimeException {
        public EmptyIntListStackException() {
        }
    }

    // stack 예외 - overflow(가득참)
    public class OverflowIntListStackException extends RuntimeException {
        public OverflowIntListStackException() {
        }
    }

    public int push(int x, int y) throws OverflowIntListStackException {
        if (top >= capacity)
            throw new OverflowIntListStackException();
        data.add(new Point(x, y));
        return top++;
    }

    // 가장 위의 데이터를 가져옴
    public Point pop() throws EmptyIntListStackException {
        if (top <= 0)
            throw new EmptyIntListStackException();
        Point p = data.remove(top - 1);
        --top;
        return p;

    }

    // 가장 위의 데이터를 들여다봄
    public Point peek() throws EmptyIntListStackException {
        if (top <= 0)
            throw new EmptyIntListStackException();
        return data.get(top - 1);
    }

    // stack을 비움
    public void clear() {
        top = 0;
    }

    // stack에서 x를 찾아 index
    public int indexOf(Point p) {
        for (int i = top - 1; i >= 0; i--) {
            if (data.get(i).equals(p))
                // 검색 성공
                return i;
        }
        // 검색 실패
        return -1;
    }

    // stack 안의 모든 데이터를 바닥 -> 위 순서로 출력
    public void dump() {
        if (top <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < top; i++) 
                System.out.println("(" + data.get(i).x + ", " + data.get(i).y + ")");            	
            System.out.println();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return top;
    }

    // stack is empty?
    public boolean isEmpty() {
        return top <= 0;
    }

    public boolean isFull() {
        return top >= capacity;
    }
}