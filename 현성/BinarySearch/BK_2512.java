package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BK_2512 {
    static int N; // 지방의 수

    static int budget(int arr[] , int max ){
        int down = 0;       //상한선을 정하기 위해서 필요한 예산의 가장 낮은 금액
        int up = max;       //상한선을 정하기 위해서 필요한 예산의 가장 높은 금액
        int up_limit = (down + up ) /2; //상한선

        while(up < down){
            int sum =0;         // 각 지방들이 원하는 예산들을 다 합치는 변수
            for(int x : arr){   // 각 지방들이 원하는 예산금액 꺼내서 변수 x에 담기
                if(x < up_limit)
                    sum += x;
                else
                    sum += up_limit;
            }
            if(sum <= max)      //'이 부분을 생각못했는데' --->요청한 예산들을 합친 값들이 충분히 지급이 가능하다면 그대로 배열의 최대값을 반환해주면 된다.
                return arr[N-1];
            else {
                up_limit--;
            }
        }
        return up_limit;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        // input 입력 받기
        N = sc.nextInt();           // 지방의 수
        int[] arr = new int[N];
        for(int i=0; i<N; i++){         // 각 지방마다 예산 입력하기
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);// 계산하기 편하게 예산 배열을 오름차순으로 정리한다.
        int max = sc.nextInt();
        System.out.println(budget(arr , max));
        // 연산 로직 부분

    }
}
