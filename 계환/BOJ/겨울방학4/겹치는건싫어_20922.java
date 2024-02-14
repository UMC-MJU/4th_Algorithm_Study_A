package BOJ.겨울방학4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] count = new int[100001];
        int start = 0;
        int end = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (end < N) {
            while (end < N && count[arr[end]] + 1 <= K) {
                count[arr[end]] += 1;
                end++;
            }
            int len = end - start;
            answer = Math.max(answer, len);
            count[arr[start]]--;
            start++;
        }
        System.out.println(answer);
    }
}
