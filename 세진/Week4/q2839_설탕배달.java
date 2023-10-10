package Week4;

import java.util.Scanner;

public class q2839_설탕배달 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int copyN = N;

        int res = 0;
        if (N >= 5) { // N이 5로 나누어 질 때
            res += copyN / 5;
            copyN -= 5 * (copyN / 5); // 일단 5를 나눌 수 있는 만큼 나눈다.
            if (copyN % 3 == 0) { // 3으로 나누어 진다면 최솟값이므로 바로 리턴
                res += copyN / 3;
                System.out.print(res);
                return;
            }
            while (copyN < N) { // 5로 나눈걸 줄여가고 3으로 나눠가면서 최솟값 탐색
                copyN += 5;
                if (copyN > N) {
                    System.out.print(-1);
                    return;
                }
                res--;
                if (copyN % 3 == 0) {
                    res += copyN / 3;
                    System.out.print(res);
                    return;
                }
            }
        }
        if (copyN % 3 != 0) { // 3으로 나누어지지 않는다면 완전히 나눌 수 없는 것 이므로 -1 출력
            System.out.print(-1);
            return;
        }
        System.out.print(copyN / 3);
    }
}
