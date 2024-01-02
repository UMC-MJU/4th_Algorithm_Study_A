package prePractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
//                System.out.print(val + " arr 배열에 들어간 수 ");
            }
            sb.append('\n');
//            System.out.print("\n");
//
//            System.out.println("dfs 메서드에 매개변수로 들어간 N = " +N
//                    + " M = " + M
//                    +" depth = "+ depth
//                    +" 에서 리턴 "
//            );
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;

//                System.out.println(i+" 번째"
//                        +" dfs 메서드에 매개변수로 들어간 N = " +N
//                        + " M = " + M
//                        +" depth + 1 = "+ (depth+1)
//                );
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }

}