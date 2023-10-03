package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 터렛 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 입력값 저장
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            // 두 점 사이의 거리 공식을 이용해 distance를 구해둡니다.
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2)));

            // 핵심 원리는, 반지름을 r1, r2로 하는 각각의 원을 만들어 교점의 갯수를 파악하는 것입니다.
            if (distance == 0) {
                if (r1 == r2) {
                    bw.write("-1\n"); // r1과 r2도 같다면 완전히 일치한다는 뜻 입니다.
                } else {{
                    bw.write("0\n"); // 그렇지 않다면 가능한 갯수가 없습니다.
                }}
            } else {
                // distance가 0이 아닐 경우에는 교점의 갯수에 따른 공식을 이용합니다.
                // 두 점에서 만날 조건
                if (Math.abs(r1 - r2) < distance && distance < r1 + r2) {
                    bw.write("2\n");
                } else if (distance == r1 + r2 || Math.abs(r1 - r2) == distance) { // 한 곳에서 만날 조건
                    bw.write("1\n");
                } else { // 만나지 않음
                    bw.write("0\n");
                }
            }
        }
        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }
}
