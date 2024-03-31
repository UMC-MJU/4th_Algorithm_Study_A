package BOJ.week24_3;

import java.io.*;
import java.util.*;

public class 사탕게임_3085 {
    static int N;
    static char[][] graph;
    static int max = 1;

    public static void main(String[] args) throws IOException{
        // 데이터 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j);
            }
        }
        // 행을 기준으로 오른쪽과 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j);
            }
        }
        // 열을 기준으로 아래쪽과 변경
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                search();
                swap(i + 1, j, i, j);
            }
        }
        System.out.println(max);
        br.close();
    }

    // swap 함수
    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = graph[x2][y2];
        graph[x2][y2] = graph[x1][y1];
        graph[x1][y1] = temp;
    }

    // 가장 긴줄 찾는 함수
    public static void search() {
        // 행 단위로 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (graph[i][j] == graph[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                }
                else {
                    count = 1;
                }
            }
        }

        // 열 단위로 찾기
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (graph[i][j] == graph[i + 1][j]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }
}
