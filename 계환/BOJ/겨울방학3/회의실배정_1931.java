package BOJ.겨울방학3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 수
        int[][] time = new int[N][2]; // 시간 정보 배열
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        Arrays.sort(time, ((o1, o2) -> {
            // 종료시간이 같을 경우 시작 시간이 빠른 순으로 오름차순 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            // 직전 종료 시간이 다음 회의 시작 시간보다 작거나 같으면 갱신한다.
            if (endTime <= time[i][0]) {
                endTime = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
