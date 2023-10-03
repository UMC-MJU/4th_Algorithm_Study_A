package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {

    // 연산자 상수 처리
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVIDE = "/";

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int N;
    private static int[] numbers;
    private static String[] operators;
    private static boolean[] used;
    private static String[] temp;
    private static int maxValue;
    private static int minValue;

    public static void main(String[] args) throws IOException {

        init();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new String[N - 1]; // 연산자의 갯수는 피연산자의 갯수 - 1이 됩니다.
        used = new boolean[N - 1]; // 연산자의 수를 따라갑니다.
        temp = new String[N - 1]; // 연산자의 수를 따라갑니다. temp는 각 테스트로 담겨질 연산자의 모음입니다.
        String[] defaultOperators = {PLUS, MINUS, MULTIPLE, DIVIDE}; // 연산자의 종류입니다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < 4; i++) { // 연산자의 갯수만큼 담아둡니다.
            int eachCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < eachCount; j++) {
                operators[count] = defaultOperators[i];
                count++;
            }
        }
        // 백트래킹을 시작합니다.
        backtracking(0);

        bw.write(maxValue + "\n" + minValue);
        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        maxValue = Integer.MIN_VALUE; // 비교되기 위한 기본 설정
        minValue = Integer.MAX_VALUE; // 비교되기 위한 기본 설정
    }

    // 백트래킹
    private static void backtracking(int depth) {
        if (depth == N - 1) { // N - 1개 담았다는 것은 연산자가 다 채워졌음을 뜻합니다.
            calculate();
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (used[i])
                continue;
            used[i] = true;
            temp[depth] = operators[i];
            backtracking(depth + 1);
            temp[depth] = "";
            used[i] = false;
        }
    }

    private static void calculate() {
        // temp가 다 채워졌다면 다음 수들과 연산자 순서대로 (temp 요소 순서대로) 연산을 합니다.
        int tempValue = numbers[0];
        for (int i = 0; i < N - 1; i++) {
            if (temp[i].equals(PLUS)) {
                tempValue += numbers[i + 1];
            } else if (temp[i].equals(MINUS)) {
                tempValue -= numbers[i + 1];
            } else if (temp[i].equals(MULTIPLE)) {
                tempValue *= numbers[i + 1];
            } else {
                tempValue /= numbers[i + 1];
            }
        }
        // 최댓값, 최솟값 비교 후 저장을 합니다.
        minValue = Math.min(minValue, tempValue);
        maxValue = Math.max(maxValue, tempValue);
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
