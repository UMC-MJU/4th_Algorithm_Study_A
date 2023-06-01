import java.util.Scanner;

    public class BK_2156번 {

        static Integer[] dp;
        static int[] arr;

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            int N = in.nextInt();// 마셔야하는 포도잔 수

            dp = new Integer[N + 1];// 메모이제이션 할 배열
            arr = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                arr[i] = in.nextInt();//각 술잔에 들어있는 양을 기록 , i를 부터 하는 이유는 헷갈려서
            }

            dp[0] = arr[0];
            dp[1] = arr[1];


            //dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
            //주의 사항 : 전에 풀었던 계단오르기 문제처럼 연속해서 3개는 불가능인걸 생각해줘야 한다.
            if(N > 1) {
                dp[2] = arr[1] + arr[2];
            }

            System.out.println(recur(N));
        }
        //6  10  13  9  8  1
        static int recur(int N) {
            //N은 3부터 null이기 떄문에 3이상일 경우 if문으로 들어간다.
            if(dp[N] == null) {
                dp[N] = Math.max( Math.max(   recur(N - 2), recur(N - 3) + arr[N - 1]    ) + arr[N],
                                            recur(N - 1)    );

            }

            return dp[N];
        }
    }

