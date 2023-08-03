import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init(); // bw, br 세팅
        arraySetting(); // 배열 전처리 진행
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int test = Integer.parseInt(br.readLine());
            bw.write(arr[test] + "\n"); // 각 test에 맞는 값 출력
        }
        bw.close();
        br.close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void arraySetting() {
        arr = new int[11]; // N이 1 ~ 10

        arr[1] = 1; // 초깃값 (1)
        arr[2] = 2; // 초깃값 (1 + 1, 2)
        arr[3] = 4; // 초깃값 (1 + 1 + 1, 1 + 2, 2 + 1, 3)
        for (int i = 4; i <= 10; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]; // 핵심 점화식
            // 4부터는 arr[i - 1] + arr[i - 2] + arr[i - 3]과 같다고 할 수 있다.
            /*
            각 경우의 수에서 마지막에 어떤 수를 더했는지를 기준으로 공통점을 묶어보면 다음과 같다.
            예시 : N이 5일 때
            맨 마지막에 1을 더하는 경우
            [1 + 3 + 1 + 1]
            [1 + 1 + 1 + 1 + 1]
            [1 + 2 + 1 + 1]
            [3 + 1 + 1]
            [1 + 1 + 2 + 1]
            [2 + 2 + 1]
            [2 + 1 + 1 + 1]
            맨 마지막에 2를 더하는 경우
            [3 + 2]
            [2 + 1 + 2]
            [1 + 2 + 2]
            [1 + 1 + 1 + 2]
            맨 마지막에 3을 더하는 경우
            [1 + 1 + 3]
            [2 + 3]
            이때 각각 보면, "맨 마지막에 1을 더하는 경우"에서 맨 마지막 1을 제외해보면 합이 4가 된다. 즉 4의 경우의 수이다.
            또 "맨 마지막에 2를 더하는 경우"에서 맨 마지막 2를 제외해보면 합이 3이 된다. 즉 3의 경우의 수이다.
            "맨 마지막에 3을 더하는 경우"에서 맨 마지막 3을 제외해보면 합이 2가 된다. 즉 2의 경우의 수이다.
            따라서 이를 일반화하면 arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] (i >= 4)가 된다.
             */
        }
    }
}