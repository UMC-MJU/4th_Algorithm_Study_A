package BOJ.겨울방학5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQeen_9663 {

    public static int[] arr;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(answer);
    }

    public static void nQueen(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[row] = i;
            if (possibility(row)) {
                nQueen(row + 1);
            }
        }
    }

    public static boolean possibility(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 위치할 경우
            if (arr[i] == arr[row]) {
                return false;
            }
            // 대각선에 있는 경우
            if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
