package BinarySearch;

import java.util.Scanner;

public class BK_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input 입력 받기
        int tree = sc.nextInt();        //나무의 수
        int length = sc.nextInt();      // 상근이가 가져가야 할 나무의 길이
        int[] arr = new int[tree];
        int min =0;                     //나무의 가장 낮은 높이
        int max =0;                     //나무의 가장 높은 높이
        for(int i=0; i<arr.length; i++){//각 나무별 길이
            arr[i] = sc.nextInt();
            if(max < arr[i])
                max = arr[i];
        }

        //로직 계산
        int sum=0 ;
        int limit =0;
        while (min < max){
            limit = (min + max) /2;//자르는 기준선
//            System.out.println("limit = "+limit);
            sum =0;
            for(int height : arr){
                if(height > limit)
                    sum += (height - limit);
            }
//            System.out.println("sum = "+sum);
            if(sum == length)
                break;

            if(sum < length){       // 가져가야 할 나무의 길이가 모자를경우 --> 자르는 기준선을 낮추어서 가져가야 할 나무의 길이를 늘린다.
                max = limit;
//                System.out.println("max = "+max);

            }
            else{                   //가져가야 할 나무의 길이가 더 많은경우 --> 자르는 기준선을 높여서 가져가야 할 나무의 길이를 줄인다.
                min = limit+1;
//                System.out.println("min = "+min);
            }
        }
        System.out.println(limit);
    }
}
