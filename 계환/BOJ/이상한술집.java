package BOJ.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이상한술집 {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException{
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 주전자 수
        int K = Integer.parseInt(st.nextToken());  // 사람 수
        int[] mak = new int[N];  // 주전자에 들어있는 막걸리 양 배열

        long start = 1;
        long end = 0;  // 이분탐색의 오른쪽 값, 인당 나눠줄 수 있는 최댓값

        for (int i = 0; i < N; i++) {
            mak[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, mak[i]);  // 오른쪽 끝값은 막걸리 양중의 최대로 설정한다.
        }

        while (start <= end) {
            long person = 0;
            long mid = (start + end) / 2;

            // mid값에 따라서 몇명에게 나눠줄 수 있는지 계산해서 person에 저장한다.
            for (int i = 0; i < N; i++) {
                person += mak[i] / mid;
            }

            // 나눠줄 수 있는 인원이 K값보다 크거나 같으면 더 많이씩 나눠줘도 된다. -> 오른쪽 구간 탐색
            if (K <= person) {
                start = mid + 1;
            }
            // 나눠줄 수 있는 인원이 K값보다 작으면 더 적게 나눠줘야 한다. -> 왼쪽 구간 탐색
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
        close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void close() throws IOException {
        br.close();
    }
}
