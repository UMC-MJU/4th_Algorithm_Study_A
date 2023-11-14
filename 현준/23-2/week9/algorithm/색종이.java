import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 색종이 {

    private static final int X_NUMBER = 0; // X 인덱스
    private static final int Y_NUMBER = 1; // Y 인덱스
    private static final int PAPER_SIZE = 10; // 각 색종이의 크기

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        init();
        int N = Integer.parseInt(reader.readLine());
        int[][] papers = new int[N][2];
        int maxY = 0;
        int maxX = 0;
        // 값 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            papers[i][X_NUMBER] = Integer.parseInt(st.nextToken());
            papers[i][Y_NUMBER] = Integer.parseInt(st.nextToken());
            maxX = Math.max(maxX, papers[i][X_NUMBER] + PAPER_SIZE); // 최대 X 파악
            maxY = Math.max(maxY, papers[i][Y_NUMBER] + PAPER_SIZE); // 최대 Y 파악
        }

        // 0 ~ maxX, 0 ~ maxY를 보며 색종이라면 체크
        boolean[][] map = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                for (int k = 0; k < N; k++) {
                    // 주의: 각 색종이의 이후 x, 이후 y 크기에 도달되면 안 됨
                    if (papers[k][X_NUMBER] <= i && i < papers[k][X_NUMBER] + PAPER_SIZE) {
                        if (papers[k][Y_NUMBER] <= j && j < papers[k][Y_NUMBER] + PAPER_SIZE) {
                            if (map[i][j]) { // 이미 체크되었다면 패스
                                continue;
                            }
                            map[i][j] = true;
                        }
                    }
                }
            }
        }
        // 색종이인 것만 출력
        int count = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (map[i][j]) {
                    count++;
                }
            }
        }

        writer.write(count + "");
        close();
    }

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
