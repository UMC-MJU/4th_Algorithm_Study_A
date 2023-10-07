package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        // 5kg로 최대한 들고 나머지를 3kg로 든다.
        // 5로 나눴을 때 깔끔하게 나눠지는 지 확인하고
        while (true) {
            if (N % 5 == 0) {
                System.out.println(N / 5 + answer);
                break;
            } else if (N < 0) {
                System.out.println(-1);
                break;
            }
            N -= 3;
            answer++;
        }
    }
}
