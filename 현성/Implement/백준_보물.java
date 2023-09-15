package algorithm;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer a[] = new Integer[N];
        Integer b[] = new Integer[N];

        for(int i=0; i<N; i++){
            a[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            b[i]=sc.nextInt();
        }
        //오름차순으로 정렬
        Arrays.sort(a);
        //내림차순으로 정렬
        Arrays.sort(b,Collections.reverseOrder());
        
        int result = 0;
        for(int i=0; i<N; i++){
            result +=(a[i] * b[i]);
        }
        System.out.println(result);

    }
}