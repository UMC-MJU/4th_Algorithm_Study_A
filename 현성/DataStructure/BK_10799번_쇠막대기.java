import java.util.*;

public class BK_10799번_쇠막대기 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //입력값 받기

        Stack<Character> stack = new Stack<>();
        int result =0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){//(일경우 스택에 저장하고 뒤에 오는 괄호가 (인지 )인지에 따라서 처리해주기
                stack.push(ch);
            }else if(ch == ')'){// )이게 왔다면 일단 스택에서 꺼내는데 만약 (이게 없었다면 꺼낼게 없을것이다 .
                stack.pop();
                if(str.charAt(i-1) == '('){//앞에 (한개 더 있는것으로 연달아 ((..(이렇게 되어있는경우 쌓여있는만큼 더해주기
                    result += stack.size();
                }else{// 괄호를 )닫을때마다 막대기가 한개씩 레이저에게 잘리는경우 1씩 더해주기
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}