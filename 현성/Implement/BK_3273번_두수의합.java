import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BK_3273번_두수의합 {
    static int isRight(int arr[] , int x ){
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr){
            set.add(a);
        }
        int count =0;
        for(int target : arr){
            int number = x - target;// 목표 x의 값에서 수열을 뺀 값 number가 set에 있다면
                if(set.contains(number)){
                    count++;
                }
        }
        return count/2;
        //나누기 2를 하는 이유는 set에 넣은 수열들을 하나씩 검사할 때 x를 만족하는 두수의 합이 x를 만족하는 경우가 중복해서 들어가기 때문입니다.

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 수열의 크기
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken(" ")); // n만큼의 수열 완성시키기

        }
        int x =Integer.parseInt(br.readLine()); // 수열의 두 수를 뽑아서 만들어야하는 target 숫자
        int result = isRight(arr , x );

        System.out.println(result);
    }

}