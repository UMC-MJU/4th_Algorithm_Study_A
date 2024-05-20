import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 도영이_음식 {

    static int N;
    static int[][] recipe;
    static int[][] selected;
    static boolean[] used;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine()); // 1 <= N <= 10
        recipe = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            recipe[i][0] = Integer.parseInt(tokenizer.nextToken()); // 신맛
            recipe[i][1] = Integer.parseInt(tokenizer.nextToken()); // 쓴맛
        }

        // 음식을 만드는 기준: 재료를 2개 ~ N개 사용하는 경우
        for (int i = 1; i <= N; i++) {
            selected = new int[i][2];
            used = new boolean[N];
            backtracking(0, i);
        }
        writer.write(answer + "");
        writer.close();
        reader.close();
    }

    private static void backtracking(int depth, int size) {
        if (depth == size) {
            calculate();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            // selected[depth] = recipe[i].clone();
            selected[depth][0] = recipe[i][0];
            selected[depth][1] = recipe[i][1];

            used[i] = true;
            backtracking(depth + 1, size);
            used[i] = false;
        }
    }

    private static void calculate() {
        int sour = 1;
        int bitter = 0;
        for (int[] s : selected) {
            sour *= s[0];
            bitter += s[1];
        }
        answer = Math.min(answer, Math.abs(sour - bitter));
    }
}
