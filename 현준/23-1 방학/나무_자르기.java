import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 갯수 (1 ~ 1,000,000)
        int M = Integer.parseInt(st.nextToken()); // 가지고자 하는 나무의 길이 (1 ~ 2,000,000,000)
        long[] trees = new long[N]; // 충분하게 담아주기 위해 long으로 선언

        st = new StringTokenizer(br.readLine());

        // 나무 데이터 저장
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees); // 이진 탐색 위해 정렬

        bw.write(binary(trees, M) + ""); // 결과 출력
        bw.close();
        br.close();
    }

    // 커팅 함수
    // 나무 높이가 limit보다 크다면 그 차 만큼을 더한다.
    public static long cutting(long[] trees, long limit) {
        long sum = 0;
        for (long tree : trees) {
            if (tree > limit) {
                sum += (tree - limit);
            }
        }
        return sum;
    }

    public static long binary(long[] trees, long want) {
        long start = 0; // 0 ~ tree 배열의 최댓값만큼 반복
        long end = trees[trees.length - 1];
        while (start <= end) {
            long mid = (start + end) / 2; // 중간값
            long cutting = cutting(trees, mid); // 얻어낸 커팅값
            if (cutting >= want) {
                // cutting이 want보다 크거나 같다
                // = 더 커질 수 있나 확인해야 한다 ("절단기 높이를 더 늘려도 want보다 클까?" - 구하는 이유는 절단기의 최대 높이를 구하기 때문)
                // = start를 늘린다
                start = mid + 1;
                continue;
            }
            // cutting이 want보다 작다
            // = 더 얻을 수 있어야 한다
            // = end를 낮춘다
            end = mid - 1;
        }
        return start - 1; // 마지막에 start = mid + 1을 했을 때 이 때의 start는 아직 검증되지 못한 start이기 때문에 start - 1을 리턴함
    }
}