import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int result;
    private static int N;
    private static int target; // 찾고자 하는 값
    private static int[] numbers;
    private static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        // 투 포인터 문제이긴 하지만, 생각해보니 투 포인터로 접근하지 않고 해시를 쓰면 바로 풀 수 있지 않을까 생각이 들었습니다.
        // 그런데 의도했던 것과 다른 방식으로 풀다보니 투 포인터에 대해 공부하지 못했는데 개념 학습을 할 수 있도록 하겠습니다.
        init();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(br.readLine());
        for (int number : numbers) {
            map.put(number, number); // 해시에 각 숫자를 넣어줌
        }
        for (int key : map.keySet()) { // 전체 해시맵을 돌면서
            int another = target - key; // 자신과 짝이 되는 수는 타겟에서 자신을 뺀 수 (이때, 조건이 중복되지 않은 수이므로 괜찮음)
            if (map.containsKey(another)) // 만약 해시맵이 해당 값을 키로 가지고 있다면 짝이 있다는 것이므로 증가시킴
                result++;
        }
        bw.write((result / 2) + ""); // 예시로 13이 타겟일 경우 [5, 8], [8, 5]가 나오기 때문에, 2로 나눠줘야 함
        bw.close();
        br.close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = 0;
        map = new HashMap<>();
    }
}