package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class BK_15663번 {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        //N = 3 , M = 1
        numbers = new int[N];
        visited = new boolean[N];
        //숫자 배열을 int배열에 넣는데 , 조건에 부합했던 수열은 제외하기 위해 방문 표시를 해주는 배열을 완성해준다.
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers); // 수열을 사전 순으로 출력하기 위해 미리 오름차순 정렬

        backtrack(0, new int[M]);

        System.out.println(sb.toString());

        scanner.close();
    }

    private static void backtrack(int depth, int[] combination) {

        if (depth == M) {
            //숫자들중에서 M만큼 뽑아서 수열 만들기
            for (int num : combination) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 이전에 선택한 원소를 기록하기 위한 변수

        for (int i = 0; i < N; i++) {
            if (!visited[i] && numbers[i] != prev) { // 중복을 허용하지 않도록 함
                visited[i] = true;
                combination[depth] = numbers[i];
                prev = numbers[i];

                backtrack(depth + 1, combination);

                visited[i] = false;
            }
        }
    }
}
