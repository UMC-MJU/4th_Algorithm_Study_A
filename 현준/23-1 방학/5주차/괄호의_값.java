import java.io.*;
import java.util.ArrayDeque;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init(); // bw, br 세팅

        String[] tokens = br.readLine().split(""); // 괄호 문자열 배열
        bw.write(logic(tokens) + ""); // 값 출력
        br.close();
        bw.close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static int logic(String[] tokens) {
        int result = 0; // 최종 결과
        int temp = 1; // 각각의 괄호에서 임시로 사용될 값 (곱셈 단위이기에 곱셈에서의 초깃값인 1 이용)
        ArrayDeque<String> stack = new ArrayDeque<>(); // 스택 위한 자료구조 활용
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("(")) { // (라면 스택에 쌓고, x2 연산이 진행됨
                stack.addLast(tokens[i]);
                temp *= 2;
            }
            else if (tokens[i].equals("[")){ // [라면 스택에 쌓고, x3 연산이 진행됨
                stack.addLast(tokens[i]);
                temp *= 3;
            }
            else if (tokens[i].equals(")")){ // )일 때
                // 스택이 비어있거나 스택의 맨 마지막이 자신의 짝과 일치하지 않는다면 잘못된 입력
                if (stack.isEmpty() || !stack.peekLast().equals("(")) {
                    result = 0;
                    break;
                }
                // i-1번째 문자열이 (이어야만 result에 temp를 더함. 그 이외의 경우에도 temp를 더한다면 올바르지 않음.
                if (i >= 1 && tokens[i - 1].equals("(")) result += temp;
                // )일 때 이 로직은 공통적으로 이루어짐
                stack.pollLast();
                temp /= 2;
            }
            else if (tokens[i].equals("]")){ // ]일 때
                // 스택이 비어있거나 스택의 맨 마지막이 자신의 짝과 일치하지 않는다면 잘못된 입력
                if (stack.isEmpty() || !stack.peekLast().equals("[")) {
                    result = 0;
                    break;
                }
                // i-1번째 문자열이 [이어야만 result에 temp를 더함. 그 이외의 경우에도 temp를 더한다면 올바르지 않음.
                // (()[[]])일 때, 이미 2x3x3 = 18을 더한 상태인데 이 조건이 없다면 또 18을 더하게 되기 때문임.
                if (i >= 1 && tokens[i - 1].equals("[")) result += temp;
                // ]일 때 이 로직은 공통적으로 이루어짐
                stack.pollLast();
                temp /= 3;
            }
        }
        // 최종 리턴
        return !stack.isEmpty() ? 0 : result;
    }
}