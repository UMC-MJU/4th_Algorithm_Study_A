import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기 {

    private static final int ON = 1;
    private static final int OFF = 0;
    private static final int MAN = 1;
    private static final int WOMAN = 2;

    private static boolean[] lights;
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        init();
        int N = Integer.parseInt(reader.readLine());
        lights = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            lights[i] = (ON == Integer.parseInt(st.nextToken())); // 상태 저장
        }
        int students = Integer.parseInt(reader.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(reader.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken()); // 여기에서 계속 값이 이상하게 저장됩니다.. 3 입력하면 37 이런 식으로 😭
            action(gender, number);
        }
        for (int i = 1; i <= N; i++) {
            if (i % 20 == 0) { // 출력 조건
                System.out.print("\n");
            }
            if (lights[i]) { // 켜졌으면 1, 꺼졌으면 0
                System.out.print(ON + " ");
            } else {
                System.out.print(OFF + " ");
            }
        }
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

    private static void action(int gender, int number) {
        // 남자 로직
        if (gender == MAN) {
            for (int i = 1; i < lights.length; i++) {
                if (i % number == 0) {
                    lights[i] = !lights[i];
                }
            }
            return;
        }
        // 여자 로직
        int start = number - 1;
        int end = number + 1;
        if (start == 1 || start == lights.length - 1) {
            lights[number] = !lights[number];
            return;
        }
        if (lights[start] != lights[end]) {
            lights[number] = !lights[number];
            return;
        }
        while (start > 0 && end < lights.length - 1 && lights[start] == lights[end]) {
            start -= 1;
            end += 1;
        }
        for (int i = start; i < end; i++) {
            lights[i] = !lights[i];
        }
    }
}
