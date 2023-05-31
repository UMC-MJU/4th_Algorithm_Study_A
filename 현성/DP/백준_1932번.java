package 백준;

import java.util.Scanner;

public class 백준_1932번 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int arr[][] = new int[5][];
		// 각 행의 크기는 다를수 있다.
		for (int i = 0; i < num; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
//		
//		for(int i=num-1; i>=0;i--) {
//			for(int j=0;j<num; j++) {
//			}
//		}
		/* 2차원 배열 확장for문으로 작성하여 꺼내보기 
		for (int x[] : arr) {
			for (int k : x) {
				System.out.println(k);
			}
		}
		*/
		
		
		
	}

}
