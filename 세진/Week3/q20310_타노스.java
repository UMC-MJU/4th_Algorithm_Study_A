package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class q20310_타노스 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        char[] chars = s.toCharArray(); // 문자열을 char 배열로 변환
        int zeroCount = 0; // 0 개수 카운트
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '0') zeroCount++;
        }
        Arrays.sort(chars); // char 배열 오름차순 정렬
        char[] res = new char[s.length() / 2]; // 반토막이 난 result char 배열 선언
        for (int i = 0; i < zeroCount / 2; i++) {
            res[i] = '0'; // 0 개수 반토막 만큼 0 채우기
        }
        for (int i = zeroCount / 2; i < res.length; i++) {
            res[i] = '1'; // 나머지 1로 채우기
        }
        for (char i : res) {
            System.out.print(i);
        }
    }
}