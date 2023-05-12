package chapter4_기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class IntListQueueTester {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntListQueue s= new IntListQueue(64);
	       Random rand = new Random();
	        int[] data = new int[64];
		
		while(true) {
			System.out.println();
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.println("(1) 인큐  (2) 디큐  (3) 피크  (4) 덤프  (0) 종료" );
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch(menu) {
			case 1:
				System.out.println("데이터: ");
                data[0] = rand.nextInt(100);
                data[1] = rand.nextInt(100);
				try {
					s.enque(data[0], data[1]);
				}catch(IntQueue.OverflowIntQueueException e) {
					System.out.println("Queue is Full");
				}
				break;
				
			case 2:
				try {
					IntListQueue.Queue queue = s.deque();
                    System.out.printf("디큐한 데이터는 (%d, %d)입니다.\n", queue.x, queue.y);					
				}catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("Queue is Empty");
				}
				break;
				
			case 3:
				try {
					IntListQueue.Queue queue = s.peek();
                    System.out.printf("피크한 데이터는 (%d, %d)입니다.\n", queue.x, queue.y);
				}catch(IntQueue.EmptyIntQueueException e) {
					System.out.println("Queue is Empty");
				}
				break;
				
			case 4:
				s.dump();
				break;
			}
			
		}
	}

}
