package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BK_1920 {
    static int search (int a[] , int key){

        int front = 0;
        int back = a.length-1;


        while(front <= back) {
            int mid = (front + back)/2;     //비교할 배열의 가운데 인덱스
            if (key < a[mid]){
                back = mid-1;               //만약 비교한 숫자가 작다면 작은 범위내에 있다는것으로 범위를 반으로 줄여주기 위해서 마지막 인덱스를 옮겨준다.
            }
            else if (key > a[mid])          //만약 비교한 숫자가 크다면 앞 인덱스를 옮겨준다.
                front = mid+1;
            else{
                return 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       // A배열에 들어갈 숫자의 개수
        int[] a= new int[N];
        for(int i =0 ; i<N; i++)    //배열에다가 숫자 집어넣기
            a[i]  = sc.nextInt();

        Arrays.sort(a);             //배열 오름차순으로 정리 ( 1, 2, 3, 4, 5)

        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();       // 비교할 숫자의 개수 입력받기
        for(int j=0; j<M; j++){
            int num = sc.nextInt(); //비교 숫자 입력 받기
            int result = search(a , num);
            if(result >=0) {        //result가 0보다 큰 양수라면 비교할 배열에 있다는 뜻으로 1을 추가해준다.
                sb.append(1).append('\n');
                continue;
            }
            sb.append(0).append('\n');//result가 0보다 작은 음수라면 비교할 배열에 없다는 뜻으로 0을 추가해준다.
        }
        System.out.println(sb);
    }
}
