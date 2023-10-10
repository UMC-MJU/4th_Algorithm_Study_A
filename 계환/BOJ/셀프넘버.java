package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 셀프넘버 {

    public static void main(String[] args) throws IOException{
        int index = 10000; // 1~10000까지의 수
        boolean[] nonSelfNumbers = new boolean[index+1]; // 셀프 넘버를 구분할 배열 선언

        for (int i = 1; i <= nonSelfNumbers.length; i++) {
            if (d(i) < index)
                nonSelfNumbers[d(i)] = true; // 셀프 넘버가 아니면 true를 대입
        }
        for (int i = 1; i < nonSelfNumbers.length-1; i++) {
            if (nonSelfNumbers[i] == false){
                System.out.println(i);
            }
        }
    }

    public static int d(int n) {
        int self = n;
        while(n > 0) { // n이 0이 될 때까지 반복
            self += (n % 10); // 일의 자리에 있는 수를 self에 누적
            n /= 10; // 자릿수가 하나씩 줄어듦
        }
        return self;
    }
}
