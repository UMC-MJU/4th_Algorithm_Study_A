package BOJ.겨울방학6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] price = new int[N];

            for (int j = 0; j < N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            int max = price[N - 1];
            long total = 0;

            for (int j = N - 1; j >= 0; j--) { // 역방향 탐색
                max = Math.max(max, price[j]);
                total += max - price[j];
            }
            System.out.println(total);
        }
    }
}
