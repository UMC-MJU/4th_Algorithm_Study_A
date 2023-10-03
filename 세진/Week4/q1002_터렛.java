package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1002_터렛 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int x1, y1, r1, x2, y2, r2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 원의 중심 사이 거리
            int maxR = Math.max(r1, r2);
            int minR = Math.min(r1, r2);
            if (r1 == r2) { // 반지름이 같을 때
                if (distance == 0) { // 원의 중심이 일치할 때
                    System.out.println(-1);
                } else if (distance > r1 + r2) { // 겹치지 않을 때
                    System.out.println(0);
                } else if (distance == r1 + r2) { // 접할 때
                    System.out.println(1);
                } else { // 아니면 두 점에서 만남
                    System.out.println(2);
                }
            } else { // 두 원의 반지름이 다를 때
                if (distance <= maxR) { // 작은 원의 중심이 큰 원 안에 있을 때
                    if (distance == 0) { // 두 원의 중심이 같을 때
                        System.out.println(0);
                    } else if (maxR - minR > distance) { // 한 원이 다른 원에 속할 때
                        System.out.println(0);
                    } else if (maxR - minR == distance) { // 한 원이 다른 원에 접할 때
                        System.out.println(1);
                    } else { // 아니면 두 점에서 만남
                        System.out.println(2);
                    }
                } else { // 작은 원의 중심이 큰 원 밖에 있을 때
                    if (r1 + r2 > distance) {
                        System.out.println(2);
                    } else if (r1 + r2 == distance) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
            }
            T--;
        }
    }
}
