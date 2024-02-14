package BOJ.겨울방학4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                ((o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) { // 절댓값이 같은 경우
                        // 음수가 앞으로 가도록
                        return o1 > o2 ? 1 : -1;
                    } else {    // 절댓값이 같지 않은 경우 절댓값이 작은 순서로 정렬
                        return Math.abs(o1) - Math.abs(o2);
                    }
                })
        );

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) { // 0을 입력받은 경우, 출력
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}
