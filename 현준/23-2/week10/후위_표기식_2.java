package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;

public class 후위_표기식_2 {

    private static final double ALPHABET_A = 65;

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        init();
        int N = Integer.parseInt(reader.readLine()); // 알파벳 개수

        String[] inputs = reader.readLine().split(""); // 입력값
        ArrayDeque<Double> stack = new ArrayDeque<>(); // 결과 담을 스택 (처음에는 문자열을 위주로 저장했었는데 double로 보관하는 게 더 맞는 방법임을 알았습니다.)
        HashMap<String, Double> scores = new HashMap<>(); // 문자열 별 값 저장

        for (int i = 0; i < N; i++) { // 차례로 A, B, C.. 저장
            scores.put(String.valueOf((char) (ALPHABET_A + i)), Double.parseDouble(reader.readLine()));
        }

        for (int i = 0; i < inputs.length; i++) {
            if (isOperator(inputs[i])) { // 연산자면 -> 스택 두 값 꺼내서 연산 후 저장
                stack.addLast(calculate(inputs[i], stack.pollLast(), stack.pollLast()));
            } else { // 피연산자면 -> 문자에 해당되는 값을 스택에 저장
                stack.addLast(scores.get(inputs[i]));
            }
        }

        writer.write(String.format("%.2f", stack.pollLast())); // 소수점 둘째자리 출력 및 반올림 적용
        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        reader.close();
        writer.close();
    }

    // A ~ Z일 시 피연산자, 그 외는 연산자
    private static boolean isOperator(final String input) {
        for (char i = 'A'; i <= 'Z'; i++) {
            if (input.equals(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }

    // 연산자에 맞는 결과 리턴
    private static double calculate(final String operator, final double left, final double right) {
        if (operator.equals("+")) {
            return left + right;
        }
        if (operator.equals("-")) {
            return right - left;
        }
        if (operator.equals("/")) {
            return right / left;
        }
        return left * right;
    }
}
