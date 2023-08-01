import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 최종 메모리 : 316760 KB, 최종 시간 : 2868 ms
public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    // 문제 해결을 위한 Node 클래스를 만듦
    private static class Node implements Comparable<Node> {
        private int document; // 서류
        private int interview; // 면접

        public Node(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        // document 순위 오름차순 정렬
        // compareTo 방식에 대해 헷갈린다. 계속 반복 학습해야 한다.
        public int compareTo(Node other) {
            if (other.document > this.document)
                return -1;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        init(); // bw, br 세팅
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int count = 0; // 각 테스트에서의 결괏값
            int N = Integer.parseInt(br.readLine());
            Node[] arr = new Node[N]; // Node 배열 생성
            for (int j = 0; j < N; j++) { // 값 저장
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                arr[j] = new Node(document, interview);
            }
            Arrays.sort(arr); // 편리한 환경에서 계산하기 위해 정렬 진행 (서류 점수 오름차순)
            int min_interview = 100001; // N은 100,000까지 갈 수 있기 때문에 100,001로 둔다.
            for (int j = 0; j < N; j++) { // 시간 복잡도를 고려하여 O(N)만에 끝내야 한다.
                // "이미 document 순위로 오름차순 정렬"되어 있기 때문에,
                // min_interview보다 순위가 크다면 두 개 순위가 모두 작다는 뜻이 된다.
                if (arr[j].interview > min_interview)
                    continue;
                min_interview = Math.min(min_interview, arr[j].interview); // min_interview 갱신
                count++;
            }
            bw.write(count + "");
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}