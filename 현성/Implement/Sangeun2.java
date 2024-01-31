import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int cnt;
    private static ArrayList<Integer>[] list;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (testCase-- > 0) {

            st = new StringTokenizer(reader.readLine());

            N = Integer.parseInt(st.nextToken());//국가수
            M = Integer.parseInt(st.nextToken());//비행기종류

            list = new ArrayList[N +1];
            visit = new boolean[N +1];

            for (int i = 0; i<= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i< M; i++) {
                st = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            sb.append(N -1 + "\n");

        }
        System.out.print(sb);

    }
}
