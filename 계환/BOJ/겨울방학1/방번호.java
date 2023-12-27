package BOJ.겨울방학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num == 9) {
                arr[6]++;
            }else {
                arr[num]++;
            }
        }

        int six = arr[6] / 2;
        if (arr[6] % 2 == 1) {
            six ++;
        }
        arr[6] = six;

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}
