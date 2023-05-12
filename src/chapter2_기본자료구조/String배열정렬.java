package chapter2_기본자료구조;

public class String배열정렬 {

	static void showData(String[] items) {
//		출력하기
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}

	}

	static void swap(String[] items, int i, int j) {
		String temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	static void sortData(String[] items) {
		for (int i = 0; i < items.length-1; i++) {
			
			for (int j = i+1; j < items.length; j++) {
				if (items[j].compareTo(items[i]) < 0) {
					swap(items, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] data = { "apple", "melon", "banana", "grape", "watermelon" };

		System.out.println("String 데이터 : ");
		showData(data);

		sortData(data);
		System.out.println();
		System.out.println("정렬 후 결과 : ");
		showData(data);

	}
}
