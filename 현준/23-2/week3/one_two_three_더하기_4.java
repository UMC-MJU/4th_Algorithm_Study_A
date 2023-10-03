package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class one_two_three_더하기_4 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        int T = Integer.parseInt(br.readLine());

        numbers = new int[10001]; // n은 양수이며 10,000보다 작거나 같다
        for (int i = 0; i <= 3; i++) { // 초깃값 설정: n이 1 ~ 3일 때는 해당 값으로 저장됨
            numbers[i] = i;
        }

        // 테스트 횟수만큼 진행
        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            bw.write(logic(number) + "\n");
        }

        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static int logic(int number) {
        if (number <= 3)
            return numbers[number];
        for (int i = 4; i <= number; i++) {
            /* 점화식을 파악 완료하였습니다.
            n이 3 이하일 때는 n값 그대로 나옵니다.
            n이 4 이상일 때는 (numbers[n - 1] + numbers[n - 2]) - numbers[n - 3]이 됩니다.
            여기에서 중요한 점은, [n - 3]이 3으로 나누어 떨어질 경우 numbers[n]은 1 증가되어야 합니다.
            얻어걸린 점화식 같아 살짝 아쉽습니다.
             */
            numbers[i] = (numbers[i - 1] + numbers[i - 2]) - numbers[i - 3];
            if ((i - 3) % 3 == 0) {
                numbers[i] += 1;
            }
        }
        return numbers[number];
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
