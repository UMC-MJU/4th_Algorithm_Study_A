package BOJ.겨울방학7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선긋기_2170 {

    public static int N; // 선을 그은 횟수
    public static int[][] list;
    public static int start;
    public static int end;
    public static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        start = list[0][0];
        end = list[0][1];
        total = end - start;

        for (int i = 1; i < N; i++) {
            if (list[i][0] < end) { // 선의 start 값이 이전 선의 end 값보다 작은 경우
                if (end < list[i][1]) { // 선의 end 값이 이전 선의 end 값보다 큰 경우
                    total += list[i][1] - end;
                } else continue;
            } else { // 윗 선과 겹치지 않는 경우
                total += list[i][1] - list[i][0];
            }
            // 끝 값 갱신
            end = list[i][1];
        }
        System.out.println(total);
    }
}
