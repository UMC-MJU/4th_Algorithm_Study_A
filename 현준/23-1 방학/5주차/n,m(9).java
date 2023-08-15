import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[] numbers;
    private static boolean[] used;
    private static int[] temp;
    // 순서를 가지며 (사전 순), 중복되는 수열이 여러 번 출력되면 안 되기 때문에 LinkedHashSet을 써야 함.
    // 중복이 나올 수 있는 이유는 수를 입력받을 때 같은 수를 입력받을 수 있기 때문이다.
    // 즉 [2 2 4]를 받았다면 2를 서로 바꾼 [2 2 4]가 두 번 나올 수 있다. 이러한 케이스를 없애야 하는 것이다.
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1]; // 각 숫자가 저장되는 배열
        used = new boolean[N + 1]; // 각 숫자 당 사용했는지 여부를 표시하는 배열
        temp = new int[M + 1]; // 최종적으로 M개의 수를 고를 때 수들이 저장될 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 값 저장
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers); // 수열이 사전 순으로 증가하는 순서대로 되어야 하므로 정렬을 한다.
        backtracking(1); // depth를 1부터 진행하며 시작
        set.forEach(System.out::println); // 최종 출력
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) throws IOException {
        // 종결 조건
        if (depth == M + 1) { // M개만큼 골랐다면 store 진행
            store();
            return;
        }

        // 핵심 포인트
        for (int i = 1; i <= N; i++) {
            if (!used[i]) { // 사용하지 않은 수일 때만 가능하도록
                used[i] = true;
                temp[depth] = numbers[i]; //
                backtracking(depth + 1); // 되돌려놓기
                used[i] = false; // 되돌려놓기
            }
        }
    }

    private static void store() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= M; i++) {
            sb.append(temp[i] + " "); // temp를 돌면서 문자열 결합 (ex : 1, 2, 3 뽑았을 경우 "1 2 3")
        }
        set.add(sb.toString()); // 최종 취합된 문자열을 set에 보관
    }
}
