package BOJ.겨울방학3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N + 1];   // 소수인지 판단하는 배열, false로 초기화
        StringBuilder sb = new StringBuilder();
        // 0,1은 소수가 아니다.
        check[0] = true;
        check[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!check[i]) { // 소수일때
                for (int j = i * i; j <= N; j += i) {
                    // 소수의 배수들은 소수가 아니기 때문에 true
                    check[j] = true;
                }
            }
        }
        for (int i = M; i <= N; i++) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
