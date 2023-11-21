import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numberBaseBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] MH = new String[N];

        int[][]MH_info = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            MH[i] = st.nextToken();
            MH_info[i][0] = Integer.parseInt(st.nextToken());
            MH_info[i][1] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(i != j){
                    for(int k=1; k<=9; k++){
                        boolean flag = true;
                        for(int s=0; s<N; s++){
                            int strike =0;
                            int ball =0;
                            String str = MH[s];
                            if (str.charAt(0) - '0' == i)
                                strike++;
                            if (str.charAt(1) - '0' == j)
                                strike++;
                            if (str.charAt(2) - '0' == k)
                                strike++;
                            if (str.charAt(0) - '0' == j || str.charAt(0) - '0' == k)
                                ball++;
                            if (str.charAt(1) - '0' == i || str.charAt(1) - '0' == k)
                                ball++;
                            if (str.charAt(2) - '0' == i || str.charAt(2) - '0' == j)
                                ball++;
                            if (MH_info[s][0] != strike || MH_info[s][1] != ball) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            ans++;

                    }
                }
            }
        }
        System.out.println(ans);
    }
}
