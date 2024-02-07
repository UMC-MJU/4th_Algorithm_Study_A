package BOJ.겨울방학7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 칸토어집합_4779 {

    public static int N;
    public static int totalLength;
    public static StringBuilder kanto;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) { // 파일의 끝에서 입력을 멈춘다.
            kanto = new StringBuilder();
            N = Integer.parseInt(str);
            totalLength = (int) Math.pow(3, N);
            for (int i = 0; i < totalLength; i++) {
                kanto.append("-");
            }
            dfs(kanto, 0, totalLength);
            System.out.println(kanto);
        }
    }

    public static void dfs(StringBuilder kanto, int start, int end) {
        if (end - start == 1) { // 선의 길이가 1이면 멈춘다.
            return;
        }
        int length = end - start;
        int pieceLength = length / 3; //한조각 길이
        for (int i = start + pieceLength; i < start + (pieceLength * 2); i++) {
            kanto.setCharAt(i, ' '); // 공백으로 치환
        }
        dfs(kanto, start, start + pieceLength); // 왼쪽
        dfs(kanto, start + (pieceLength * 2), end); // 오른쪽
    }
}
