package chapter2_기본자료구조;

import java.util.Random;

public class Matrix {

	private int[][] arr;
	private int rowCount;
	private int colCount;

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public Matrix(int rows, int cols) {

		this.arr = new int[rows][cols];
		this.rowCount = rows;
		this.colCount = cols;

	}

	protected static Matrix addMatrix(Matrix m1, Matrix m2) {

		Matrix result = new Matrix(m1.rowCount, m2.colCount);
		for (int r = 0; r < m1.rowCount; r++) {
			for (int c = 0; c < m1.colCount; c++) {
				result.arr[r][c] = m1.arr[r][c] + m2.arr[r][c];
			}
		}

		return result;

	}

	protected Matrix transposeMatrix() {
		Matrix result = new Matrix(colCount, rowCount);
		for (int r = 0; r < this.rowCount; r++) {
			for (int c = 0; c < this.colCount; c++) {
				result.arr[c][r] = this.arr[r][c];
			}
		}
		return result;
	}

	protected static Matrix multiplyMatrix(Matrix m1, Matrix m2) {
		Matrix result = new Matrix(m1.rowCount, m2.colCount);
		for (int r = 0; r < m1.rowCount; r++) {
			for (int c = 0; c < m2.colCount; c++) {
				int value = 0;
				for (int e = 0; e < m1.colCount; e++) {
					value += m1.arr[r][e] * m2.arr[e][c];
				}
				result.arr[r][c] = value;
			}
		}

		return result;
	}

	protected void setArr() {
		Random rand = new Random(System.currentTimeMillis());

		for (int r = 0; r < this.rowCount; r++) {
			for (int c = 0; c < this.colCount; c++) {
				arr[r][c] = rand.nextInt(100);
			}
		}

		try {
			Thread.sleep(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}

	}

	protected void showArr(String name) {
		System.out.println(name + " 행렬 Array");
		for (int r = 0; r < this.rowCount; r++) {
			for (int c = 0; c < this.colCount; c++) {
				System.out.print(arr[r][c] + "\t");
			}
			System.out.print("\n");
		}
	}

}
