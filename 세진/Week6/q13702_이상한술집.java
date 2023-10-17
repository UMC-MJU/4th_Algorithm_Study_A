package Week6;

import java.util.Scanner;

public class q13702_이상한술집 {
    static int N, K;
    static int[] kettles;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        kettles = new int[N];
        int start = 0; // 최소 막걸리 ml
        int end = 0; // 최대 막걸리 ml
        for(int i = 0; i < N; i++) {
            kettles[i] = sc.nextInt();
            end = Math.max(end, kettles[i]);
        }
        if(K == 0 || K == 1){
            System.out.println(end);
            return;
        }
        long res = 0;

        // start와 end로 이분탐색 진행
        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0; // 나눠지는 사람 수

            for(int kettle: kettles){
                cnt += (int) (kettle / mid);
            }
            if(cnt >= K){ // 만약 나눠지는 사람이 더 많거나 같으면 막걸리를 더 줘도 되므로
                start = (int) mid + 1; // 최솟값 늘려가면서 나눠줄 수 있는 막걸리 최대 탐색
                res = mid;
            } else {
                end = (int) mid - 1;
            }
        }
        System.out.println(res);
    }
}