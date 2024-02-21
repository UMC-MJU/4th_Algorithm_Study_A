import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사2 {

    private static class Consult {

        private int day;
        private int cost;
        private int bonus;

        public Consult(final int day, final int cost, final int bonus) {
            this.day = day;
            this.cost = cost;
            this.bonus = bonus;
        }
    }

    /*
    NOT SOLVED: 24.02.16 (금)
    퇴사 2 - 골드5
    시도했던 마지막 코드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N; // 1 <= N <= 1,500,000
        Consult[] consults;
        long[] dp;

        N = Integer.parseInt(reader.readLine());
        dp = new long[N + 1];
        consults = new Consult[N + 1];
        long result = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int cost = Integer.parseInt(tokenizer.nextToken());
            int bonus = Integer.parseInt(tokenizer.nextToken());
            consults[i] = new Consult(i, cost, bonus);
        }

        /*
        for (int i = 1; i <= N; i++) {
            dp[i] = consults[i].bonus;
        }
        */
        long temp = 0;
        for (int i = N; i > 0; i--) {
            if (consults[i].day + consults[i].cost > N + 1) {
                dp[i] = temp;
            } else {
                dp[i] = Math.max(temp, consults[i].bonus + dp[Math.min(consults[i].day + consults[i].cost, N)]);
                temp = Math.max(temp, dp[i]);
            }
        }

        /*
        내 접근
        - 틀린 원인 1: temp와 idx를 혼용하여 사용함 - temp와 index가 가리키는 게 안 맞을 수 있음
        - 틀린 원인 2: temp, idx에 대한 초기화를 어떻게 해야 할 지 몰랐음
        for (int i = N; i > 0; i--) {
            // 현재 날짜 + 소모 날짜가 N일을 초과할 경우 해당 날짜의 기댓값은 0으로 되어야 한다. (선택 불가능 처리)
            if (consults[i].day + consults[i].cost > N + 1) {
                dp[i] = 0;
                idx = i; // 여기에서 초기화를 했기 때문에 문제가 되었을 수 있음
                temp = 0;
                continue;
            }
            // dp[i] = consults[i].bonus; // 기본값
            // idx (최댓값이 저장된 위치)를 사용할 수 있다면 - idx를 이용한다.
            // idx (최댓값이 저장된 위치)를 사용할 수 없다면 - 자신의 cost 직후 날짜를 이용한다.
            if (consults[i].cost + idx > N + 1 || consults[i].day + consults[i].cost > idx) {
                dp[i] = consults[i].bonus + dp[Math.min(consults[i].day + consults[i].cost, N)];
            } else {
                dp[i] = consults[i].bonus + Math.max(Math.min(consults[i].day + consults[i].cost, N), temp);
            }
            if (temp <= dp[i]) {
                temp = dp[i];
                idx = i;
            }
        }
         */
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }

        writer.write(result + "");
        writer.close();
        reader.close();
    }
}
