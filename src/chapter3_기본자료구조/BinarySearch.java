package chapter3_기본자료구조;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

	public static void inputData(int[] data) {

		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}

	}

	public static void showData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + "");
		}
	}

	public static void sortData(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}

			}
		}

	}

	public static int linearSearch(int[] data, int key) {

		int i = 0;
		while (true) {
			if (i == data.length)
				return -1;
			if (data[i] == key)
				return i;
			i++;
		}
	}

	public static int binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (data[pc] == key)
				return pc;
			else if (data[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return -1;

	}

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}
}