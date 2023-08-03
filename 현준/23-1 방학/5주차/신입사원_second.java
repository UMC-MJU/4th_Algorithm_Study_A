import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 최종 메모리 : 302188 KB, 최종 시간 : 868 ms
public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int count = 0; // 각 테스트에서의 결괏값
            int N = Integer.parseInt(br.readLine());
            int[] peoples = new int[N + 1];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                peoples[document] = interview; // 해당 document 번째의 값을 interview로 둔다. 이렇게 하면 Node 클래스를 만들 필요가 없다.
            }
            int min_interview = 100001;
            for (int j = 1; j <= N; j++) {
                if (peoples[j] > min_interview) // peoples[j]는 Node 배열을 정렬해둔 것과 같은 원리가 된다.
                    continue;
                min_interview = Math.min(peoples[j], min_interview); // min_interview 갱신
                count++;
            }
            bw.write(count + ""); // 최종 출력
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