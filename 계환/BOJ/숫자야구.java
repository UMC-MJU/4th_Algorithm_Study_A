package BOJ.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        init();
        StringTokenizer st;
        boolean[] answer = new boolean[1000];

        // 가능한 정답의 경우 answer 배열을 true로 설정
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);
            // 0이 포함되면 안된다.
            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;
            // 세 자리의 숫자가 모두 달라야한다.
            if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) continue;
            answer[i] = true;
        }

        int N = Integer.parseInt(br.readLine());  // 몇 번 질문하는지
        for (int i = 0; i < N; i++) {  // 질문 횟수 만큼만
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());  // 판단할 숫자
            int strike = Integer.parseInt(st.nextToken());  // 스트라이크
            int ball = Integer.parseInt(st.nextToken());    // 볼

            for (int temp = 123; temp < 1000; temp++) {
                // 정답 가능한 숫자인 경우에만 체크한다.
                if (answer[temp]) {
                    int s = 0, b = 0;
                    // 두 개의 숫자를 자릿수 별로 비교하면서 스트라이크/볼 판단을 한다.
                    for (int k = 0; k < 3; k++) {
                        char numberSplit = Integer.toString(number).charAt(k);
                        for (int m = 0; m < 3; m++) {
                            char tempSplit = Integer.toString(temp).charAt(m);
                            // 숫자도 같고 자릿수도 같으면 스트라이크+1
                            if (numberSplit == tempSplit && k == m) s++;
                            // 숫자는 같고 자릿수는 다르면 볼+1
                            else if (numberSplit == tempSplit && k != m) b++;
                        }
                    }
                    // 위에서 계산한 스트라이크/볼과 주어진 스트라이크/볼이 같으면 true로 남겨두고,
                    // 다르면 false로 지워서 다음 반복문에는 판단하지 않도록 한다.
                    if (strike == s && ball == b) answer[temp] = true;
                    else answer[temp] = false;
                }
            }
        }

        int ans = 0;
        for (int i = 123; i < 1000; i++) {
            if (answer[i]) ans++;
        }

        System.out.println(ans);
        close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void close() throws IOException {
        br.close();
    }
}
