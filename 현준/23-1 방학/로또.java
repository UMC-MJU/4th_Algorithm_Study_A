import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int N;
    private static StringTokenizer st;
    private static int[] numbers; // 숫자들이 담기는 배열
    private static int[] temp; // 각 케이스에서 쓰이는 임시 배열
    private static boolean[] used; // 중복 방지
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) { // N이 0이면 종료
                break;
            }
            numbers = new int[N + 1]; // 배열 생성 및 값 저장
            for (int i = 1; i <= N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers); // 사전순 위함
            used = new boolean[N + 1];
            temp = new int[6 + 1]; // 6개 뽑을 것 -> 1번 인덱스부터 시작할거라 +1
            backtracking(1, 6); // goal (6개) 중 1개부터 시작할 것
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
    private static void backtracking(int depth, int goal) throws IOException {
        if (depth == goal + 1) { // goal만큼 다 채웠다면 출력
            print();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i] && temp[depth - 1] < numbers[i]) { // 해당 수를 사용하지 않았고, 오름차순이 유지되어야만 사용 가능
                used[i] = true;
                temp[depth] = numbers[i]; // 해당 depth번째의 temp 배열값을 numbers[i]로 저장
                backtracking(depth + 1, goal);
                used[i] = false; // 사용 여부 다시 되돌림
            }
        }
    }
    private static void print() throws IOException {
        for (int i = 1; i < temp.length; i++) {
            bw.write(temp[i] + " ");
        }
        bw.write("\n");
    }
}