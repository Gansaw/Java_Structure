package chapter2_기본자료구조;

import java.util.Random;

public class 메소드배열전달 {
	static void getArr(int[] arr) {
//		난수 생성하여 배열에 입력
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);

		}

	}

	static void showArr(int[] arr) {
//		출력하기
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	

	static int findMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) { 
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
	
	static void swap(int[] arr, int i, int j) {
		int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}
	
	static void reverseArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]> arr[j]) {
                	swap(arr, i, j);
                }
            }
        }
    }

	public static void main(String[] args) {
		int[] arr = new int[10];

		getArr(arr);
		System.out.print("랜덤변수 : ");
		showArr(arr);
		
		System.out.println("\n최댓값 : " + findMax(arr));
		
		sortArr(arr);
		System.out.print("정렬 후 결과 : " );
		showArr(arr);
		
		reverseArr(arr);		
		System.out.print("\n역 정렬 : " );
		showArr(arr);
		

	}
}
