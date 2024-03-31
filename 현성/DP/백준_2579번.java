package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class 백준_2579번{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());;
		
		arr = new Integer[N+1];
		dp = new Integer[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
				arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(N>1)
		dp[2] = arr[2]+arr[1];
		
		System.out.println(max(N));
		
}
	public static int max(int num) {
		
		if(dp[num]==null) {
			dp[num] = Math.max(max(num-2), max(num-3)+arr[num-1])+arr[num];
		}
		return dp[num];
	}
	
}