package chapter3_기본자료구조;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {

	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData o) {
	    int result = this.name.compareTo(o.name);
	    if (result != 0) {
	        return result;
	    }
	    result = Integer.compare(this.height, o.height);
	    if (result != 0) {
	        return result;
	    }
	    return Double.compare(this.vision, o.vision);
	}


	static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static void sortData(PhyscData[] data) {

		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[i].compareTo(data[j]) < 0)
					swap(data, i, j);

			}
		}

	}

	static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(key))
				return i;
			
		}
		return -1;
		
	}
	
	static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length-pl;
		
		do {
			int pc = (pl+pr)/2;
			if(data[pc].compareTo(key) == 0)
				return pc;
			else if(data[pc].compareTo(key) < 0)
				return pc = pl + 1;
			else
				return pc = pr - 1;
			
	} while (pl <= pr);

	}
public class ObjectComparableSearch {

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);
		
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}
	static void showData(PhyscData[]arr) {
		System.out.println();
		for (PhyscData fruit: arr) {
			System.out.print(fruit+" ");
		}
		System.out.println();
	}
	
	
}

}