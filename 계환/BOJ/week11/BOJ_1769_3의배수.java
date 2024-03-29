package BOJ.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1769_3의배수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int count = 0;
        while (X.length() > 1) {
            int sum = 0;
            for (int i = 0; i < X.length(); i++) {
                char c = X.charAt(i);
                sum += Integer.parseInt(String.valueOf(c));
            }
            X = String.valueOf(sum);
            count++;
        }
        System.out.println(count);
        if (Integer.parseInt(X) % 3 == 0) {
            System.out.println("YES");
        }else System.out.println("NO");
    }
}
