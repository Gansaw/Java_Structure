package chapter4_기본자료구조;

public class IntStack {

	private int[] stk; // stack 배열
	private int capacity; // stack 용량
	private int ptr; // stack 포인터

	// 생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}

	}
	
	// stack 예외 - empty(비어있음)
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// stack 예외 - overflow(가득참)
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public int push(int x) throws OverflowIntStackException {
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// 가장 위의 데이터를 가져옴
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 가장 위의 데이터를 들여다봄
	public int peak() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	//stack을 비움
	public void clear() {
		ptr = 0;
	}

	// stack에서 x를 찾아 index
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x)
		// 검색 성공
				return i;
		}
		// 검색 실패
		return -1;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return ptr;
	}
	
	// stack is empty?
	public boolean isEmpty() {
		return ptr <=0;
	}
	
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	//stack 안의 모든 데이터를 바닥 -> 위 순서로 출력
	public void dump() {
//		if (ptr <= 0)
		if(isEmpty())
			System.out.println("스택이 비어있습니다.");
		else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i]+" ");
				System.out.println();
			}
		}
	}
	

	

}
