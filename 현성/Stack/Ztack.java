import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ztack {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for(int i=0; i<number; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num ;
            if(str.equals("push")){
                num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if(str.equals("top")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(stack.peek());
            }else if (str.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                    continue;
                }
                num = stack.pop();
                System.out.println(num);
            }else if(str.equals("size")){
                System.out.println(stack.size());
            }else if(str.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }else{
                System.out.println("-1");
            }

        }

    }
}