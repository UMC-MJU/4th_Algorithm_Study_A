import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 킹 {

    // 24.05.02 (목)

    static final int LIMIT = 8;

    static HashMap<String, Integer> commandMap = new HashMap<>();
    static HashMap<String, Integer> column = new HashMap<>(); // 문자를 숫자로 표기
    static HashMap<Integer, String> columnReverse = new HashMap<>(); // 숫자를 다시 문자로 표기

    static int kingX;
    static int kingY;
    static int stoneX;
    static int stoneY;

    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; // 일반적인 문제에서는 아래로 내려갈수록 +1을 해야 했지만 이 문제의 경우에는 -1을 해야 함
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 정보 작성
        commandMap.put("T", 0);
        commandMap.put("RT", 1);
        commandMap.put("R", 2);
        commandMap.put("RB", 3);
        commandMap.put("B", 4);
        commandMap.put("LB", 5);
        commandMap.put("L", 6);
        commandMap.put("LT", 7);

        // A ~ H를 인덱스화, 그 반대도 마찬가지
        int index = 1;
        for (char i = 'A'; i <= 'H'; i++) {
            column.put(String.valueOf(i), index);
            columnReverse.put(index, String.valueOf(i));
            index++;
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        String kingPos = tokenizer.nextToken();
        kingX = column.get(kingPos.split("")[0]);
        kingY = Integer.parseInt(kingPos.split("")[1]);

        String stonePos = tokenizer.nextToken();
        stoneX = column.get(stonePos.split("")[0]);
        stoneY = Integer.parseInt(stonePos.split("")[1]);

        int play = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < play; i++) {
            String command = reader.readLine();
            int commandIdx = commandMap.get(command);
            int kingNy = kingY + dy[commandIdx];
            int kingNx = kingX + dx[commandIdx];

            if (kingNy > LIMIT || kingNy < 1 || kingNx > LIMIT || kingNx < 1) {
                continue;
            }
            if (kingNy == stoneY && kingNx == stoneX) { // 킹이 이동하려던 위치가 돌이 있던 좌표일 경우
                int stoneNy = stoneY + dy[commandIdx];
                int stoneNx = stoneX + dx[commandIdx];
                if (stoneNy > LIMIT || stoneNy < 1 || stoneNx > LIMIT || stoneNx < 1) { // 돌도 같은 방향으로 이동시키지만, 문제가 생길 경우 패스
                    continue;
                }
                stoneX = stoneNx;
                stoneY = stoneNy;
            }
            kingX = kingNx;
            kingY = kingNy;
        }

        // 출력
        writer.write((columnReverse.get(kingX) + kingY) + "\n" + (columnReverse.get(stoneX) + stoneY) + "\n");
        writer.close();
        reader.close();
    }
}
