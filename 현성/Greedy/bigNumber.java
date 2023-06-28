package Greedy;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bigNumber {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt(); //배열의 개수
        int repeat = sc.nextInt(); // 더하는 숫자의 개수
        int  max = sc.nextInt(); // 연속해서 더 할 수 있는 숫자

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int bigOne = list.get(size-1);
        int bigTwo = list.get(size-2);
        int result =0;

        while(true){
            for(int i=0; i<max; i++){
                result += bigOne;
                repeat--;
                if(repeat ==0)
                    break;
            }
            result += bigTwo;
            repeat--;
            if(repeat ==0)
                break;
        }


        System.out.println(result);


}
}
