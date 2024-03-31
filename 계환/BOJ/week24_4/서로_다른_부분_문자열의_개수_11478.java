package BOJ.week24_4;

import java.io.*;
import java.util.*;

public class 서로_다른_부분_문자열의_개수_11478 {

    static int length;
    static String S;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        length = S.length();

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j+i <= length; j++) {
                String slice = S.substring(j, j + i);
                set.add(slice);
            }
        }
        System.out.println(set.size());
    }
}
