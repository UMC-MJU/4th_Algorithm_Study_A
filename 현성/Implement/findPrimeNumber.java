package practice;

import java.util.*;

public class findPrimeNumber {

    static boolean sosoo(int num) { // 소수라면 true 소수가 아니라면 false
        if(num < 2) {
            return false;
        }else {
            for(int i = 2; i*i<=num; i++) {
                if(num % i ==0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();


        for(int j = num1; j<=num2; j++) {
            if(sosoo(j)) {
                list.add(j);
            }
        }
        for(int k : list) {
            System.out.println(k);
        }
    }

}