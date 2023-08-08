import java.io.*;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static ArrayDeque<String> stack;
    private static String[] command;
    private static int result;
    private static int operand;

    public static void main(String[] args) throws IOException {
        init();

        command = br.readLine().split(""); // 수식
        result = 0; // 결과
        operand = 1; // 초기 기본 부호 : 양수

        logic();
        bw.write(result + "");

        br.close();
        bw.close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void logic() {
        stack = new ArrayDeque<>();
        for (String c : command) {
            if (!isOperand(c)) { // 연산자가 아니라면 스택에 넣음
                stack.addLast(c);
            } else { // 어쩔 수 없이 else를 쓰게 됐네요..
                storeNumber(); // 연산자라면 지금까지 스택에 저장된 값을 저장
            }

            if (isNeedChangeOperand(c)) // 만약 연산자를 바꿀 필요가 있다면 연산자를 바꿔줘야 함. 이때, 음수에서 양수로 바꿀 일은 없음.
                changeOperand();
        }
        storeNumber();
    }

    private static void changeOperand() { // 연산자 음수로 바꿔주기
        operand = -1;
    }

    private static boolean isNeedChangeOperand(String c) { // 연산자 바꿀 필요성 있는지 알려주기 (현재 연산자가 양수이고 -를 마주쳤을 때만)
        return c.equals("-") && operand == 1;
    }

    private static boolean isOperand(String c) { // 연산자인지 검증
        return "+-".contains(c);
    }

    private static void storeNumber() { // 연산자를 마주쳤다면 그 이전까지 스택에 저장된 값을 꺼내서 정수로 변환 후 결과에 넣어줘야 함
        int temp = 0;
        int digit = 1;
        while (!stack.isEmpty()) {
            temp += (Integer.parseInt(stack.pollLast()) * digit);
            digit *= 10;
        }
        result += (operand * temp);
    }
}
