package chapter2_기본자료구조 ;

import java.util.Random;

public class calculate {
    static void getArr(int[][] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = rand.nextInt(6);
            }
        }
    }

    static void showArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void multipleArr(int[][] A, int[][]B, int[][]C) {
    	
    }

    static void sumArr(int[][] A, int[][]A1, int[][]A2) {
    	
    }
    public static void main(String[] args) {
    	int[][] A = new int[2][3];
        int[][] B = new int[3][4];
        
        getArr(A);
        showArr(A);

        getArr(B);
        showArr(B);
    }
}
