
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16953 {

        public static void main(String[] args) throws IOException {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int count = 0;

            while (true){
                if(B == A){
                    count++;
                    break;
                }
                if(B%2 == 0){
                    B = B/2;
                    count++;
                }else{
                    String temp = Integer.toString(B);
                    if(temp.charAt(temp.length() - 1) == '1'){
                        B= Integer.parseInt(temp.substring(0,temp.length()-1));
                        if(B < A){
                            count = -1;
                            break;
                        }
                        count++;

                    }else{
                        count = -1;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }


