package BOJ.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 후위표기식2 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 피연산자의 개수
        int N = Integer.parseInt(br.readLine());

        // 피연산자를 저장할 배열
        Double[] numArray = new Double[N];
        for (int i = 0; i < N; i++) {
            numArray[i] = Double.parseDouble(br.readLine());
        }

        // 후위표기식
        String expression = br.readLine();

        // 스택 선언
        Stack<Double> stack = new Stack<>();

        double result = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('A' <= expression.charAt(i) && expression.charAt(i) <= 'Z') {
                stack.push(numArray[expression.charAt(i) - 'A']);
            } else if (!stack.isEmpty()) {  // stack이 비어있지 않다면
                double second = stack.pop();
                double first = stack.pop();
                switch (expression.charAt(i)) {
                    case '+':
                        result = first + second;
                        stack.push(result);
                        continue;
                    case '-':
                        result = first - second;
                        stack.push(result);
                        continue;
                    case '*':
                        result = first * second;
                        stack.push(result);
                        continue;
                    case '/':
                        result = first / second;
                        stack.push(result);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}
