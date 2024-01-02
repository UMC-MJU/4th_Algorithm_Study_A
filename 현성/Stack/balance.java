package prePractice;

import java.io.*;
import java.util.Stack;

public class balance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        
        while(true){
            String str = reader.readLine();
            
            if(str.equals(".")) break;
            
            builder.append(balanceWorld(str))
                    .append("\n");
        }
        System.out.println(builder);
    }

    private static String balanceWorld(String str) {

        Stack<Character> stack = new Stack<>();
        //괄호기호들만 스택에 들어가게끔 만들고 문자들은 스택에 들어가지 않는다.
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[')
                stack.push(ch);
            else if(ch == ')'){
                if(stack.empty() || stack.peek()!='(') return "no";
                else stack.pop();
            }
            else if(ch == ']'){
                if(stack.empty() || stack.peek()!='[') return "no";
                else stack.pop();
            }
        }

        if(stack.empty()) return "yes";

        else return "no";

    }

}
