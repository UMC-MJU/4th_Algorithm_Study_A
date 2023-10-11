import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 셀프넘버 {

    private static BufferedWriter bw;
    private static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        init(); // BufferedReader 설정
        initArray(); // 사용되는 array 초기회
        storeSelfNumbers(); // 배열들에 셀프 넘버 됐는지 기록
        print(); // 출력
        close(); // BufferedReader 닫음
    }

    private static void init() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void initArray() {
        numbers = new boolean[10001]; // 10000보다 작거나 같은 (상수 처리해도 좋았을 것 같네요)
    }

    private static void storeSelfNumbers() {
        for (int i = 1; i <= 10000; i++) { // 1부터 10000까지 셀프 넘버 만들어지는지 기록
            makeNumber(String.valueOf(i));
        }
    }

    private static void makeNumber(String number) { // 숫자보다 문자열이 더 계산에 편리
        if (number.equals("10000")) { // 10000으로 셀프 넘버 만들려고 하면 초과되므로 패스
            return;
        }

        int temp = 0;
        if (number.length() < 2) { // 1 ~ 9라면 본인 숫자 x 2
            temp = 2 * Integer.parseInt(number);
        } else {
            temp += Integer.parseInt(number); // 아니라면 본인 수 더하고
            for (int i = 0; i < number.length(); i++) { // 각 자릿수 더하기
                temp += Integer.parseInt(number.split("")[i]);
            }
        }
        if (temp >= 10001) { // 계산된 값이 10000을 넘으면 패스
            return;
        }
        numbers[temp] = true; // 해당 배열에 기록
    }

    private static void print() throws IOException {
        for (int i = 1; i <= 10000; i++) {
            if (!numbers[i]) { // 셀프 넘버면 false이기에 이것만 출력
                bw.write(i + "\n");
            }
        }
    }

    private static void close() throws IOException {
        bw.close();
    }
}
