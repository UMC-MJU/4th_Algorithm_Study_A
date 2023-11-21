package BOJ.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시피하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N X N 크기의 복도
        int N = Integer.parseInt(br.readLine());
        String[][] way = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                way[i][j] = st.nextToken();
                System.out.print(way[i][j]);
            }
            System.out.println();
        }

        br.close();
    }
}
