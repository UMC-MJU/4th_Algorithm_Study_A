package BOJ.겨울방학3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시리얼번호_1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기타의 개수
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, ((o1, o2) -> {
            // 1번 조건
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if (num1 > 0 && num1 < 10) {
                        a += num1;
                    }
                    if (num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }
                if (a == b) {
                    return o1.compareTo(o2);
                }
                return a - b;
            }
        }));
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

// 시리얼번호 정렬, 시리얼번호는 알파벳 대문자와 숫자로 이루어져 있다.
// A가 B의 앞에 오는 경우는 다음과 같다.
// 1. 짧은 것이 먼저온다.
// 2. 길이가 같다면, 숫자 합을 비교해서 작은 것이 먼저온다.
// 3. 1,2번으로도 비교할 수 없으면 사전순으로 비교한다.
