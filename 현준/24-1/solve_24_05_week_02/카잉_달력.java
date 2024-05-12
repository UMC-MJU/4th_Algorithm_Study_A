import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 카잉_달력 {

    // 24.05.12 (일)
    // 실패 문제

    static int T;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int nx = 2;
            int ny = 2;
            map = new HashMap<>();
            map.put("<1:1>", 1);
            map.put("<2:2>", 2);
            int value = 3;

            if (map.containsKey(generateKey(x, y))) {
                writer.write(map.get(generateKey(x, y)) + "\n");
                continue;
            }

            while (!map.containsKey(generateKey(x, y)) && !map.containsKey(generateKey(M, N))) {
                nx = calculateX(nx, M);
                ny = calculateY(ny, N);
                map.put(generateKey(nx, ny), value);
                value++;
            }

            if (!map.containsKey(generateKey(x, y)) && map.containsKey(generateKey(M, N))) {
                writer.write("-1\n");
            } else {
                writer.write(map.get(generateKey(x, y)) + "\n");
            }
            // <1:1>은 처음 달력, <2:2>는 두 번째 달력, <M:N>은 마지막 달력

            // M = 10, N = 12면 <10:12>, 이게 마지막 달력
            // x = 1, y = 1부터 시작 (첫 번째)
            // 다음은 x' = 2, y' = 2 (두 번째)
            // 다음은 x' = 3, y' = 3 (세 번째)
            // 다음은 x' = 4, y' = 4 (네 번째)
            // 다음은 x' = 5, y' = 5 (다섯 번째)
            // 다음은 x' = 6, y' = 6 (여섯 번째)
            // 다음은 x' = 7, y' = 7 (일곱 번째)
            // 다음은 x' = 8, y' = 8 (여덟 번째)
            // 다음은 x' = 9, y' = 9 (아홉 번째)
            // 다음은 x' = 10, y' = 10 (열 번째)
            // 다음은 x' = 1, y' = 11 (열한 번째)
            // x = 1, y = 11은 <1:11>, 이건 몇 번째? => 열한 번째
        }

        writer.close();
        reader.close();
    }

    private static int calculateX(int x, int M) {
        if (x < M) {
            return x + 1;
        }
        return 1;
    }

    private static int calculateY(int y, int N) {
        if (y < N) {
            return y + 1;
        }
        return 1;
    }

    private static String generateKey(int x, int y) {
        return "<" + x + ":" + y + ">";
    }

    // 정답
    private static void correct(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        int x, y;
        int num = sc.nextInt();
        boolean tf = false;

        for (int j = 0; j < num; j++) { // num: 횟수
            m = sc.nextInt();
            n = sc.nextInt();
            x = sc.nextInt()-1;    // % 연산이 0일 수 있기 때문에 -1 해준다.
            y = sc.nextInt()-1;    // % 연산이 0일 수 있기 때문에 -1 해준다.

            for (int i = x; i < (m * n); i += m) { // x 기준으로 M번째일 때 마다 x는 그대로고 y값만 변동

                if (i % n == y) {
                    // %연산은 0이 나올 수있다.
                    // 만약 i % n == 0 이면 y값은 1 이상 이므로 if에 걸릴 수가 없다 .
                    // 그래서 x-1, y-1 해준다. 만약 y가 1이면 0이됨

                    System.out.println(i+1); // 출력할 때 +1 해준다.
                    tf = true;
                    break;
                }
            }
            if (!tf) {
                System.out.println(-1);
            }
            tf = false;
        }
    }
}
