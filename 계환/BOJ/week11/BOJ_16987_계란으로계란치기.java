package BOJ.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로계란치기 {

    static int N;
    static int[] dura;
    static int[] weight;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dura = new int[N];    // 내구도 배열
        weight = new int[N];  // 무게 배열

        for (int i = 0; i < N; i++) {  // 입력받기
            st = new StringTokenizer(br.readLine());
            dura[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0);
        System.out.println(max);
    }

    public static void recursion(int index, int count) {
        // 마지막 계란까지 다 들어봤으면 종료
        if (index == N) {
            max = Math.max(max, count); // 최댓값 갱신
            return;
        }
        // 손에 든 계란이 깨져있거나 모든 계란이 깨진 경우
        if (dura[index] <= 0 || count == N - 1) {
            // 다음 계란(한 칸 오른쪽)을 든다.
            recursion(index + 1, count);
            return;
        }

        int tempCount = count;
        for (int i = 0; i < N; i++) {
            // 들고있는 계란과 타겟 계란이 같은 경우, 타겟 계란이 깨져있는 경우 패스
            if (index == i || dura[i] <= 0) {
                continue;
            }
            // 계란 치기
            hitEgg(index, i);
            // 아래 두 if문 같이 쓰면 안됨. 두 계란 모두 깨질 수 있다.
            // 들고있는 계란이 깨지면 count+1
            if (dura[index] <= 0) {
                count++;
            }
            // 타겟 계란이 깨지면 count+1
            if (dura[i] <= 0) {
                count++;
            }
            // 재귀 호출 -> 다음 계란 들어보기
            recursion(index + 1, count);
            // 다음 반복문을 위해 값 원상복구
            recoveryEgg(index, i);
            count = tempCount;
        }
    }
    // 계란 치기 메서드
    public static void hitEgg(int handEgg, int targetEgg) {
        dura[handEgg] -= weight[targetEgg];
        dura[targetEgg] -= weight[handEgg];
    }
    // 치기 복구 메서드
    public static void recoveryEgg(int handEgg, int targetEgg) {
        dura[handEgg] += weight[targetEgg];
        dura[targetEgg] += weight[handEgg];
    }

}
