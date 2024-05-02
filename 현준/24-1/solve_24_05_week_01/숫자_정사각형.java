import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자_정사각형 {

    // 24.05.01 (수)
    // 쉬운 문제였으나 비교적 오래 걸린 문제
    // 브루트포스 유형에 대해서 무조건 백트래킹을 적용하기보다는, 이렇게 N의 크기가 작을 수 있으니 가장 간단한 접근법 (반복문)을 고려해보기
    // + 정사각형이었음을 뒤늦게 봄

    static int N; // 행
    static int M; // 열
    static int[][] map;
    static int answer = 1; // 최솟값은 1

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken()); // 행
        M = Integer.parseInt(tokenizer.nextToken()); // 열

        // N, M 최대 50 => 최대 2,500개의 숫자
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = reader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        if (N == 1 || M == 1) {
            writer.write("1");
            writer.close();
            reader.close();
            return;
        }

        // O(N^4) = O(50^4) = O(6,250,000)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = map[i][j];
                List<Integer> rightPos = sameRightPos(i, j);
                List<Integer> bottomPos = sameBottomPos(i, j);
                /*
                반례 상황
                xxxxx
                x11x1 <- 4칸짜리 정사각형이 있음에도, 맨 마지막 1의 위치로 계산했기 때문에 정사각형을 탐지를 못했다.
                x11xx
                 */
                for (int small_y : bottomPos) {
                    for (int small_x : rightPos) {
                        int crossValue = map[small_y][small_x];
                        if (j != small_x && i != small_y && value == crossValue && Math.abs(small_x - j) == Math.abs(small_y - i)) {
                            answer = Math.max(answer, Math.abs(small_x - j + 1) * Math.abs(small_y - i + 1));
                        }
                    }
                }
            }
        }

        writer.write(answer + "");
        writer.close();
        reader.close();
    }

    private static List<Integer> sameRightPos(int y, int x) {
        if (x == M - 1) {
            return new ArrayList<>(x);
        }
        List<Integer> positions = new ArrayList<>();
        for (int i = x + 1; i < M; i++) {
            if (map[y][i] == map[y][x]) {
                positions.add(i); // 경우의 수를 전부 담도록 수정
            }
        }
        return positions;
    }

    private static List<Integer> sameBottomPos(int y, int x) {
        if (y == N - 1) {
            return new ArrayList<>(y);
        }
        List<Integer> positions = new ArrayList<>();
        for (int i = y + 1; i < N; i++) {
            if (map[i][x] == map[y][x]) {
                positions.add(i); // 경우의 수를 전부 담도록 수정
            }
        }
        return positions;
    }
}
