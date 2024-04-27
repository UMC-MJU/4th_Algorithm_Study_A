import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 아기_상어 {

    // 24.04.12 (금)
    // 최단 거리, 그래프이므로 BFS를 써야 하는 것은 알고 있었음
    // 그러나 그 이후를 생각하지 못함
    /*
    https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4-Java%EC%9E%90%EB%B0%94를 참고했으나
    제출하면 틀림. 왜 그럴까??
     */

    private static final int EMPTY = 0;
    private static final int LOCATION = 9;
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    static int[][] dist; // 거리 배열
    static int[][] map;
    static int size = 2; // 상어 사이즈
    static int eat = 0; // 먹은 횟수
    static int cnt = 0; // 이동 횟수
    static int sharkY = -1;
    static int sharkX = -1;
    static int minX;
    static int minY;
    static int minDist;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];

        // initialize
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (map[i][j] == LOCATION) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = EMPTY;
                }
            }
        }

        while (true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                map[minY][minX] = 0;
                sharkY = minY;
                sharkX = minX;
                cnt += dist[minY][minX];

                if (eat == size) {
                    size++;
                    eat = 0;
                }
            } else {
                break;
            }
        }
        writer.write(cnt + "");
        writer.close();
        reader.close();
    }

    static void bfs(int x, int y) {
        ArrayDeque<Position> queue = new ArrayDeque<Position>();
        queue.addLast(new Position(x, y));

        while (!queue.isEmpty()) {
            Position position = queue.pollFirst();

            int currX = position.x;
            int currY = position.y;

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (isArea(nx, ny) && isAblePosition(nx, ny) && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[currY][currX] + 1;

                    if (isEat(nx, ny)) {
                        if (minDist > dist[ny][nx]) {
                            minDist = dist[ny][nx];
                            minX = nx;
                            minY = ny;
                        } else if (minDist == dist[ny][nx]) {
                            if (minX == nx) {
                                if (minY > ny) {
                                    minX = nx;
                                    minY = ny;
                                }
                            } else if (minX > nx) {
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                    queue.addLast(new Position(nx, ny));
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static boolean isAblePosition(int x, int y) {
        return map[y][x] <= size;
    }

    static boolean isEat(int x, int y) {
        return map[y][x] != 0 && map[y][x] < size;
    }
}
