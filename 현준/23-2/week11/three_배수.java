import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class three_배수 {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static List<Integer> goals = List.of(3, 6, 9);

    public static void main(String[] args) throws IOException {
        init();
        int result = 1; // 출력 형식 맞추기 위해 result 1부터 진행
        char[] inputs = reader.readLine().toCharArray(); // 메모리 과부하 막기 위해 char[] 사용
        int resultNumber = 0; // 변환된 최종 값

        // 1자릿수이면서 3, 6, 9였다면 0 & YES
        if (inputs.length == 1 & goals.contains(convertToSumNumber(inputs))) {
            writer.write("0\nYES");
            close();
            return;
        }

        // 1자릿수이면서 3, 6, 9가 아닐 경우 0 & NO
        if (inputs.length == 1 & !goals.contains(convertToSumNumber(inputs))) {
            writer.write("0\nNO");
            close();
            return;
        }

        // 한 자릿수가 될 때 까지
        while (inputs.length > 1) {
            int number = convertToSumNumber(inputs); // char[] to int
            if (String.valueOf(number).length() == 1) { // 만약 한 자릿수가 되었다면 변환된 최종 값을 resultNumber에 저장 후 종료
                resultNumber = number;
                break;
            }
            inputs = convertToArray(number); // int to char[]
            result++;
        }

        // 결과 출력
        writer.write(result + "\n");
        if (correct(resultNumber)) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }
        close();
    }

    // convert char[] to int
    private static int convertToSumNumber(final char[] inputs) {
        int result = 0;
        for (char input : inputs) {
            result += Integer.parseInt(String.valueOf(input));
        }
        return result;
    }

    // 3, 6, 9인지
    private static boolean correct(final int number) {
        return goals.contains(number);
    }

    // convert int to char[]
    private static char[] convertToArray(final int number) {
        String value = String.valueOf(number);
        return value.toCharArray();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
