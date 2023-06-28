package Greedy;

import java.util.Scanner;

public class becomeOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int k = sc.nextInt();
        int result =0;
        //num이 k의 배수일경우 나눌수록 빠르게 1에 가까워지기때문에
        // 최대한 나누는것이 중요한데 예를들어서 num이 17이고 k가 4인경우
        //1을 먼저 빼주고 시작해야한다 그래서 num이 k의 배수인지부터 체크를 해주는것이 중요하다.

        while (num >= k){
            if(num % k == 0 ){//배수가 맞는경우에는 최대한 나누어야 1이라는 숫자에 가까워진다 .
                num = num / k;
                result ++;
            }else if(num % k != 0){
                num -=1;
                result ++;
            }
        }
        System.out.println(result);
    }
}
