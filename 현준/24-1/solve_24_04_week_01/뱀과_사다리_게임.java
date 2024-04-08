import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임 {

    // 24.04.04 (목)
    // https://jumping-to-the-water.tistory.com/117 참고, 복습해야 함

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ladder = Integer.parseInt(tokenizer.nextToken());
        int snake = Integer.parseInt(tokenizer.nextToken());
        int[] board = new int[100 + 1];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < ladder + snake; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            board[from] = to;
        }

        int result = bfs(1, board);
        System.out.println(result);
    }

    private static int bfs(final int startNode, final int[] board) {
        int[] check = new int[100 + 1];
        ArrayDeque<Integer> queue =  new ArrayDeque<>();
        queue.addLast(startNode);
        check[startNode] = 0; // 첫 시작점 (1)의 값은 0

        while (true) {
            int visitedNum = queue.pollFirst();
            for (int i = 1; i <= 6; i++) {
                int newNode = visitedNum + i; // 현재 기준점 (visitedNum)으로부터 주사위 던졌을 때

                if (newNode > 100) { // 100을 초과한 경우에는 스킵
                    continue;
                }

                if (check[board[newNode]] == 0) {
                    queue.addLast(board[newNode]);
                    check[board[newNode]] = check[visitedNum] + 1; // ex: check[100] = check[98] + 1
                }
                if (board[newNode] == 100) {
                    return check[100];
                }
            }
        }
    }
}
