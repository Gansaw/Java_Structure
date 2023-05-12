package chapter3_기본자료구조;

import java.util.Arrays;

public class StringSearch {
	
	static void showData(String[] data) {
		for (int i = 0; i < data.length; i++)
			System.out.println(data[i] + "");
	}

	static void swap(String[] data, int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static void sortData(String[] data) {
		for (int i = 0; i < data.length-1; i++) {
			for (int j = 0; j < data.length-1 - i; j++) {
				if (data[j].compareTo(data[i]) < 0)
					swap(data, i, j);
			}
		}

	}

	static int linearSearch(String[] data, String key) {

		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(key))
				return i;
		}
		return -1;
	}

	static int stringSearch(String[] data, String key) {
		Arrays.sort(data);
		int idx = Arrays.binarySearch(data, key);
		if (idx < 0)
			return -1;
		
		else
			return idx;		
		
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry",
				"melon", "oriental melon" };

		showData(data);
		sortData(data);
		System.out.println();
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = "배";
		result = stringSearch(data, key);
		System.out.println("\nstringSearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.stringSearch(): result = " + result);

	}

}
