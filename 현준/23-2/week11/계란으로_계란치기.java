package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 계란으로_계란치기 {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static int[] durability;
    private static int[] weight;
    private static int result;
    private static int eggSize;

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        init();
        eggSize = Integer.parseInt(reader.readLine()); // 계란 박스 용량
        durability = new int[eggSize]; // 내구도
        weight = new int[eggSize]; // 무게
        result = 0;
        for (int i = 0; i < eggSize; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        writer.write(result + "");
        close();
    }

    private static void backtracking(int depth, int count) {
        if (depth == eggSize) { // 모든 계란을 다 들어봤을 경우 result 갱신
            result = Math.max(result, count);
            return;
        }
        // "손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다"
        if (durability[depth] <= 0 || count == eggSize - 1) {
            backtracking(depth + 1, count);
            return;
        }
        int tempCount = count; // 선택하는 경우의 수가 여러 개이기 때문에 count를 복구하기 위해 임시 저장
        for (int i = 0; i < eggSize; i++) {
            if (i == depth) { // 자기 자신과 같은 경우 생략
                continue;
            }
            // "깨지지 않은 다른 계란 중에서 하나를 친다"
            if (durability[i] <= 0) {
                continue;
            }
            hit(depth, i);
            // 자신이 깨졌다면 - count
            if (durability[depth] <= 0) {
                count++;
            }
            // 다른 계란이 깨졌다면 - count
            if (durability[i] <= 0) {
                count++;
            }
            backtracking(depth + 1, count); // 다음 계란으로 넘어간다
            recovery(depth, i); // 복구
            count = tempCount; // count 복구
        }
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void hit(int handleEgg, int targetEgg) {
        durability[targetEgg] -= weight[handleEgg];
        durability[handleEgg] -= weight[targetEgg];
    }

    private static void recovery(int handleEgg, int targetEgg) {
        durability[targetEgg] += weight[handleEgg];
        durability[handleEgg] += weight[targetEgg];
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
