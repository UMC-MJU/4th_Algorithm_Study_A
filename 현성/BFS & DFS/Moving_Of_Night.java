import java.io.*;
import java.util.*;
public class Moving_Of_Night {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { 2, 2, 1, -1, -2, -2, 1, -1 };
    static int[] dy = { 1, -1, 2, 2,  1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node start = new Node(x, y);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Node end = new Node(x, y);

            visited = new boolean[N][N];
            int result = BFS(start, end);
            System.out.println(result);

        }
    }
    public static int BFS(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()) {
            Node n = q.poll();
            if (n.x == end.x && n.y == end.y)
                return arr[n.x][n.y];
            for (int i = 0; i < 8; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                arr[nx][ny] = arr[n.x][n.y] + 1;
                q.add(new Node(nx, ny));
            }
        }
        return -1;
    }

}
class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}