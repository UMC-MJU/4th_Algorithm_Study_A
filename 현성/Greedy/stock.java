import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < testCase; tc++) {
            
            int dayMoney = Integer.parseInt(br.readLine());
            long[] sto = new long[dayMoney];
            long maxMoney = 0;
            long result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < dayMoney; i++) {
                sto[i]=Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= dayMoney; i++) {
                if(sto[dayMoney-i]>maxMoney) {
                    maxMoney = sto[dayMoney-i];
                }else {
                    result+=(maxMoney-sto[dayMoney-i]);
                }
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
