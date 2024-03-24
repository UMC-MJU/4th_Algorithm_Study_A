import java.io.*;
import java.util.*;

public class B_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] road = new long[N-1];
        long[] fuel = new long[N];
        for (int i=0;i<N-1;i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N;i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }
        long MIN = Integer.MAX_VALUE;
        long sum=0;
        for(int i=1;i<N;i++) {
            MIN = Math.min(MIN, fuel[i-1]);
            sum += road[i-1]*MIN;
        }
        System.out.println(sum);
    }
}