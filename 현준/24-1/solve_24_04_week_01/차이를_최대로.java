import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 차이를_최대로 {

    // 24.04.03 (수)
    // "정렬"로만 접근해서 시간을 뺏겼다.
    // 앞으로는 경우의 수가 많을 것 같으면서, 정렬이 떠오르지 않을 경우, 그러면서 N의 가짓수가 적을 경우에는 백트래킹을 고려해봐야 할 것 같다.

    private static int N;
    private static int[] arr;
    private static int[] numbers;
    private static boolean[] used;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine()); // 3 <= N <= 8
        result = 0;
        arr = new int[N];
        numbers = new int[N];
        used = new boolean[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        backtracking(0);

        writer.write(result + "");
        writer.close();
        reader.close();
    }

    private static void backtracking(final int depth) {
        if (depth == N) {
            calculate();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            arr[depth] = numbers[i];
            backtracking(depth + 1);
            used[i] = false;
        }
    }

    private static void calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]); // 정의된 수식
        }
        result = Math.max(result, sum);
    }
}
