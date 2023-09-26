package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class 타노스 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static String test;
    private static String[] testArr;
    private static boolean[] used;
    private static String[] temp;
    private static int ONE_COUNT;
    private static int ZERO_COUNT;
    public static void main(String[] args) throws IOException {
        init();
        test = br.readLine();
        used = new boolean[test.length()];
        temp = new String[used.length / 2];
        testArr = test.split("");
        test = String.join("", testArr);
        ONE_COUNT = getNumberCount(testArr, 1); // 1 갯수
        ZERO_COUNT = getNumberCount(testArr, 0); // 0 갯수

        // 1의 갯수가 절반이 될 때 까지 앞에서부터 1 삭제
        int pos = 0;
        while (getNumberCount(testArr, 1) != ONE_COUNT / 2) {
            if (testArr[pos].equals("1")) {
                testArr[pos] = "X";
            }
            pos++;
        }

        // 0의 갯수가 절반이 될 때 까지 뒤에서부터 0 삭제
        pos = testArr.length - 1;
        while (getNumberCount(testArr, 0) != ZERO_COUNT / 2) {
            if (testArr[pos].equals("0")) {
                testArr[pos] = "X";
            }
            pos--;
        }

        // 출력
        for (String s : testArr) {
            if (!s.equals("X")) {
                bw.write(s);
            }
        }
        close();
    }

    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        bw.close();
        br.close();
    }

    private static int getNumberCount(String[] arr, int number) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(String.valueOf(number))) {
                count++;
            }
        }
        return count;
    }

    /*
    시도했던 방법 1: 백트래킹 -> 시간 초과
    시도했던 방법 2: 0과 1을 정렬한 후 (사전 순으로 되려면 0부터 시작해야 하므로) 0의 갯수의 절반과 1의 갯수의 절반씩 append -> 25점
    시도했던 방법 3 (최종): 0과 1의 갯수를 파악한 뒤, 0은 뒤에서부터, 1은 앞에서부터 각각 절반 갯수씩 될 때 까지 "X"로 대체한 다음 "X"가 아닐 때 출력
    2번 방법도 될 듯 한데 왜 안되는지는 잘 모르겠습니다 😓
     */
}
