package chapter4_기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class IntListStackTester{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntListStack s = new IntListStack(64);
        Random rand = new Random();
        int[] data = new int[64];
        
        while(true) {
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
            System.out.println("(1) 푸시  (2) 팝  (3) 피크  (4) 덤프  (0) 종료 : ");
            
            int menu = sc.nextInt();
            if(menu == 0) break;
            
            switch (menu) {

            case 1:
                System.out.print("데이터: ");
                data[0] = rand.nextInt(100);
                data[1] = rand.nextInt(100);
                
                
                try {
                    s.push(data[0],data[1]);
                } catch (IntListStack.OverflowIntListStackException e) {
                    System.out.println("스택이 가득찼습니다.");
                }
                break;
                
            case 2:
                try {
                    IntListStack.Point point = s.pop();
                    System.out.printf("팝한 데이터는 (%d, %d)입니다.\n", point.x, point.y);
                } catch (IntListStack.EmptyIntListStackException e) {
                    System.out.println("스택이 비어있습니다.");
                }
                break;

            case 3:
                try {
                    IntListStack.Point point = s.peek();
                    System.out.printf("피크한 데이터는 (%d, %d)입니다.\n", point.x, point.y);
                } catch (IntListStack.EmptyIntListStackException e) {
                    System.out.println("스택이 비어있습니다.");
                }
                break;

            case 4:
                s.dump();
                break;
        }
    }
}
}