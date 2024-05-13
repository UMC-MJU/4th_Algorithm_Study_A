package BOJ.week24_8;

import java.io.*;
import java.util.*;

public class 카잉달력_6064 {
    static int T;
    static int year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based
            int y = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based

            boolean found = false;
            for (int k = 0; k * M < M * N; k++) {
                int year = k * M + x;
                if (year % N == y) {
                    System.out.println(year + 1); // 0-based to 1-based
                    found = true;
                    break;
                }
                if (year > 40000 * 40000) { // 너무 큰 값 처리 제한
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }
        }
    }
}


