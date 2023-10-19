import java.util.Scanner;

public class sumNumber {
    static int[] arr;
    static Integer[] dp;		// 메모이제이션 할 dp
    static int max;			// 최댓값 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();//수열의 개수
        arr = new int[number];
        dp = new Integer[number];
        for(int i = 0; i < number; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        max = arr[0];//최대값을 찾기 위하여 일단 dp배열과 max를 초기화 해놓고

        // dp배열의 가장 뒤에서부터 내려가는 Top-down방식을 이용
        recur(number - 1);
        System.out.println(max);
    }

    static int recur(int N) {//10 -4 3 1 5 6 -35 12 21 -1
        // 탐색하지 않은 인덱스라면
        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
            //recur(N-1)은 현재 메모이제이션 되어있는 인덱스 앞에 값을 의미한다.
            // 해당 dp[N]과 max 중 큰 값으로 max 갱신
            max = Math.max(dp[N], max);
        }
        return dp[N];
    }
}
