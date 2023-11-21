package BOJ.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] array = new boolean[101][101];
        int answer = 0; //색종이가 있는 영역의 넓이

        for (int i = 0; i < n; i++) {  // 색종이 개수만큼
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!array[j][k]){
                        array[j][k] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
