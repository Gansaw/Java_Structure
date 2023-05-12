package chapter2_기본자료구조;

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


}

public class 과제1_2장기본자료구조 {

	static void showData(PhyscData[] items) {
		
		for (int i = 0; i < items.length; i++) {
			System.out.println("(" + items[i].name + ", " + items[i].height + ", " + items[i].vision + ")");

		}
	}

		static void swap(PhyscData[] items, int i, int j) {
			PhyscData temp = items[i];
			items[i] = items[j];
			items[j] = temp;
		}


	static void sortData(PhyscData[] items) {
		for (int i = 0; i < items.length-1; i++) {
			for (int j = i + 1; j < items.length; j++) {
				if ((items[j].compareTo(items[i])) < 0) {
					swap(items, i, j);
				}
			}
		}

	}

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("이길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };

		System.out.println("☆데이터 목록☆");
		showData(data);

		System.out.println("\n★정렬 결과★");
		sortData(data);
		showData(data);

	}

}
