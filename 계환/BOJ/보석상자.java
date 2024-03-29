package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보석상자 {

    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int color[] = new int[M]; // 색상 배열
        // sum -> 한 명 줄 때마다 +1
        int start = 1, end = 0, mid, sum = 0;

        for (int i = 0; i < M; i++) {
            color[i] = Integer.parseInt(reader.readLine());
            end = Math.max(end, color[i]);  // 오른쪽 끝값 구하기
        }

        // 이분 탐색 시작
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;

            for (int i = 0; i < M; i++) {
                if (color[i] % mid == 0) {
                    sum += color[i] / mid;
                }else{
                    sum += color[i] / mid + 1;
                }
            }

            if (sum <= N) {
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
