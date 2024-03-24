package BOJ.week24_3;

import java.io.*;
import java.util.*;

public class AtoB_16953 {

    static int min = Integer.MAX_VALUE;
    static long A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        solution(A, 1);
        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    public static void solution(long A, int depth) {
        if (A > B) {
            return;
        }
        if (A == B) {
            min = Math.min(min, depth);
            return;
        }
        solution(A * 2, depth + 1);
        solution(A * 10 + 1, depth + 1);
    }
}
