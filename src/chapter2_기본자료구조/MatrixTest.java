package chapter2_기본자료구조;

public class MatrixTest {
	
	public static void main(String[] args) {
		
		Matrix A = new Matrix(2, 3);
		Matrix A1 = new Matrix(2, 3);
		Matrix B = new Matrix(3, 4);
		
		A.setArr();
		A1.setArr();
		B.setArr();
		
		A.showArr("A");
		A1.showArr("A1");
		B.showArr("B");
		
		
//		class이름.함수 => static
		Matrix A2 = Matrix.addMatrix(A, A1);
		A2.showArr("A2");
		
		int row = A2.getRowCount();
		System.out.println("\n" + row);
		
		A2.setRowCount(A2.getRowCount());
		System.out.println("\n" + A2.getRowCount());

		Matrix D = A.transposeMatrix();
		D.showArr("\nD");
		
		Matrix C = Matrix.multiplyMatrix(A, B);
		C.showArr("\nC");
	}

}
