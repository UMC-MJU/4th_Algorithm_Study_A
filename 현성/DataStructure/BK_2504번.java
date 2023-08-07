package DataStructure;
import java.util.Scanner;
import java.util.Stack;

public class BK_2504번 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            int result = calculateValue(input);
            System.out.println(result);

            scanner.close();
        }

        private static int calculateValue(String input) {
            Stack<Character> stack = new Stack<>();
            int temp = 1; // 임시값을 저장하는 변수
            int result = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                //여는 괄호
                if (ch == '(') {
                    stack.push(ch);
                    temp *= 2;
                } else if (ch == '[') {
                    stack.push(ch);
                    temp *= 3;
                }
                //닫는 괄호
                else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        //닫는 괄호 뒤에 끝이거나 괄호 순서가 거꾸로 되어있는 경우
                        //만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. 라는 조건에 의해서 0을 반환한다.
                        return 0; // 올바르지 않은 괄호 문자열
                    }

                    if (input.charAt(i - 1) == '(') {
                    //
                        System.out.println("input.charAt("+(i-1)+") = " + input.charAt(i - 1));
                        result += temp;
                    }

                    stack.pop();
                    temp /= 2;
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        //닫는 괄호 뒤에 끝이거나 괄호 순서가 거꾸로 되어있는 경우
                        //만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다. 라는 조건에 의해서 0을 반환한다.
                        return 0; // 올바르지 않은 괄호 문자열
                    }

                    if (input.charAt(i - 1) == '[') {
                        result += temp;
                    }

                    stack.pop();
                    temp /= 3;
                }
            }

            if (!stack.isEmpty()) {
                return 0; // 올바르지 않은 괄호 문자열
            }

            return result;
        }
    }


