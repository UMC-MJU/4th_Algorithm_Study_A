import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 근손실 {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int[] routine; // 각 날짜에 따른 무게
    private static int[] temp; // 순서에 따라 담겨질 임시 배열
    private static int N;
    private static int K;
    private static int answer; // 최종 답변
    private static boolean[] used; // 백트래킹 활용

    public static void main(String[] args) throws IOException {
        init();
        answer = 0;
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        routine = new int[N];
        temp = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            routine[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        writer.write(answer + "");

        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // 백트래킹
    private static void backtracking(int depth) {
        if (depth == N) {
            calculate();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp[depth] = routine[i];
            backtracking(depth + 1);
            used[i] = false;
            temp[depth] = 0;
        }
    }

    // 무게 충족되는지 계산
    private static void calculate() {
        int weight = 500;
        for (int i = 0; i < N; i++) {
            if (weight + temp[i] - K < 500) { // 무게를 더하고 K를 뺐을 때 500 미만이 되는 순간이 있다면 안 되는 것
                return;
            }
            weight += (temp[i] - K); // 틀렸던 이유: K를 빼지 않았었다. 하루마다 K가 빠진다.
        }
        if (weight >= 500) { // 500 이상일 때만 더한다
            answer++;
        }
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
