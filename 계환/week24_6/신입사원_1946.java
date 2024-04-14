package BOJ.week24_6;

import java.io.*;
import java.util.*;

public class 신입사원_1946 {
    static int T, N, passCount;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            // 서류 순위 기준으로 오름차순 정렬
            Arrays.sort(arr, ((o1, o2) -> o1[0] - o2[0]));
            passCount = 1; // 첫번째 사람은 항상 선택됨
            int min = arr[0][1];
            for (int j = 1; j < N; j++) {
                if (arr[j][1] < min) {
                    min = arr[j][1];
                    passCount++;
                }
            }
            System.out.println(passCount);
        }
    }
}
