import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자야구 {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        init();
        HashSet<Integer> count = new HashSet<>(); // 안 되는 수들의 모음
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N]; // 각 숫자
        int[] strikes = new int[N]; // 각 숫자의 스트라이크
        int[] balls = new int[N]; // 각 숫자의 볼

        // 입력값 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            strikes[i] = Integer.parseInt(st.nextToken());
            balls[i] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < N; x++) {
            int number = numbers[x]; // 실행하려는 숫자
            int strike = strikes[x]; // 실행하려는 숫자의 스트라이크
            int ball = balls[x]; // 실행하려는 숫자의 볼

            // 주의: 각 자리는 1 ~ 9가 된다.
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    for (int k = 1; k <= 9; k++) {
                        int index = makeNumber(i, j, k); // i, j, k는 각각 백의 자리, 십의 자리, 일의 자리이며 이것으로 바로 숫자를 뽑아낸다.

                        // 만약 서로 같은 수가 있다면 스킵한다.
                        // 틀렸던 원인: 처음에는 i == j && j == k로 했었다.
                        if (i == j || j == k || i == k) {
                            count.add(index); // 안 되는 케이스이므로 담는다.
                            continue;
                        }
                        String userNumber = String.valueOf(number); // 제시된 숫자를 String화 한다.
                        String testNumber = String.valueOf(index); // 테스트 숫자를 String화 한다.
                        // 만약 스트라이크를 셌을 때 의도했던 스트라이크와 다르다면 안 되는 숫자다.
                        // 입력이 123일 때, 테스트 할 숫자가 345라면 1스트라이크 1볼이라 맞지만,
                        // 입력이 356이고 테스트 할 숫자가 345라면 1스트라이크 1볼로써 실제 의도인 1스트라이크 0볼이 아니기 때문에 345는 불가능하다.
                        // 더 쉽게 말해보면
                        // 문제의 예시에서 주어진 입력을 통해 얻을 수 있는 가능한 숫자는 324, 328이다.
                        // 324와 328은 "유저의 모든 입력 숫자" (123, 356, 327, 489)에 대해 전부 의도한 대로 스트라이크, 볼을 얻는다.
                        // 그런데 그 외의 나머지 숫자들은 의도한 것과 다르게 나오는 경우가 존재한다. 그래서 그러한 경우들을 HashSet에 담는 것이다.
                        if (countStrike(userNumber, testNumber) != strike) {
                            count.add(Integer.parseInt(testNumber)); // 따라서 담는다.
                            continue; // 이미 담겼기도 했고, 볼 작업이 더 복잡하므로 스트라이크를 먼저 세서 스킵하게 한다.
                        }
                        // 만약 볼을 셌을 때 의도했던 볼과 다르다면 안 되는 숫자다.
                        if (countBall(userNumber, testNumber) != ball) {
                            count.add(Integer.parseInt(testNumber)); // 따라서 담는다.
                        }
                    }
                }
            }
        }

        // 모든 가능한 경우를 돌려보면서 HashSet을 돌았을 때 존재하는 수라면 안 되는 수이므로 그것들을 뺀 나머지 경우만 더한 뒤 출력한다.
        int temp = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (count.contains(makeNumber(i, j, k))) {
                        continue;
                    }
                    temp++;
                }
            }
        }
        writer.write(temp + "");
        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // hundred, ten, one을 int 형으로 받았을 때 실질적인 값으로 변환
    private static int makeNumber(final int hundred, final int ten, final int one) {
        return hundred * 100 + ten * 10 + one;
    }

    // 스트라이크 판정
    // 정확히 같은 위치에 있는 것만 카운트
    private static int countStrike(String originNumber, String testNumber) {
        int count = 0;
        String[] originTokens = originNumber.split("");
        String[] testTokens = testNumber.split("");
        for (int i = 0; i < 3; i++) {
            if (originTokens[i].equals(testTokens[i])) {
                count++;
            }
        }
        return count;
    }

    // 예시 케이스를 보면 최종적으로 가능했던 숫자는 324, 328이였다. (비교 대상은 123, 356, 327, 489, 각각 1볼, 0볼, 0볼, 1볼)
    // 여기서 실수하면 안 되는 것은 같은 자리, 같은 숫자 (즉, 스트라이크 조건)에 해당되는 수는 "무시해야 한다".
    // 틀렸던 원인 2: 볼 함수를 작성할 때 스트라이크 숫자를 피하기 위해 StringBuilder를 썼었고, char[] 대신 String[]을 써서 메모리 초과가 났다.
    private static int countBall(String originNumber, String testNumber) {
        char[] originTokens = originNumber.toCharArray();
        char[] testTokens = testNumber.toCharArray();

        boolean[] onlyOrigin = new boolean[3]; // 각 자릿수가 이 수에만 독립적으로 있는 수인지 (ex: 324의 3이 324에만 있는가)
        boolean[] onlyTest = new boolean[3];
        Arrays.fill(onlyOrigin, true);
        Arrays.fill(onlyTest, true);

        for (int i = 0; i < 3; i++) {
            // 스트라이크 수 처리
            if (originTokens[i] == testTokens[i]) {
                onlyOrigin[i] = false;
                onlyTest[i] = false;
            }
        }

        HashSet<Character> originSet = new HashSet<>();
        HashSet<Character> testSet = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            if (onlyOrigin[i]) { // origin에 i번째 수가 정확히 origin에만 있는 수라면
                originSet.add(originTokens[i]); // originSet에 넣어줌
            }
            if (onlyTest[i]) { // 그 반대도 동일
                testSet.add(testTokens[i]);
            }
        }

        originSet.retainAll(testSet); // 교집합 처리

        return originSet.size(); // 교집합 수 반환
    }


    private static void close() throws IOException {
        writer.close();
        reader.close();
    }
}
