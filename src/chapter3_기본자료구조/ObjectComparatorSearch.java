package chapter3_기본자료구조;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

public class ObjectComparatorSearch {

	static class Fruit {
		private String name;
		private int price;
		private String date;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		private Fruit(String name, int price, String date) {
			this.name = name;
			this.price = price;
			this.date = date;

		}

	}

	static void showData(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("(" + arr[i].name + ", " + arr[i].price + ", " + arr[i].date + ")");
		}

	}
	
	static void sortData(Fruit[] arr, Comparator<Fruit> cc_price) {
		
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j].getPrice() > arr[j+1].getPrice()){
					Fruit temp = arr[j];
						arr[j] = arr[j+1];
							arr[j+1] = temp;
				}
			}
		}
		
	}	
	
	static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<Fruit> cc_name) {
		int pl = 0;
		int pr = arr.length - pl;
		do {
			int pc = (pl+pr)/2;
			if(arr[pc].getName().equals(cc_name)) 
				return pc;
			else if(arr[pc].getName().compareTo(cc_name.toString()) < 0)
				return pl = pc + 1;
			else
				return pr = pc - 1;		
		
			
		} while(pl <= pr);
	}
	
	public static void main(String[] args) {
		Fruit[] arr = { new Fruit("사과", 200, "2023-5-8"), new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"), new Fruit("바나나", 50, "2023-5-18"), new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("람다식 정렬(가격)후 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("comparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit a1, Fruit a2) {
				return(a1.name.compareTo(a2.name));
			}
		};
		
		
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {// 익명클래스 사용
			public int compare(Fruit a1, Fruit a2) {
				if(a1.price == a2.price)
					return 0;
				else if (a1.price > a2.price)
					return 1;
				else
					return -1;
			}
		};
		


		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("comparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	}

}
