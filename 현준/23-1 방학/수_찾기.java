import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N의 최댓값은 100,000
        // M의 최댓값은 100,000
        // 즉 순차 탐색의 경우에는 100,000 * 100,000 = 10,000,000,000 (백억)번이 걸릴 것임.

        // 전체 수 입력받기
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A); // 이진 탐색 위해 정렬

        int M = Integer.parseInt(br.readLine()); // 실험할 데이터 셋 입력받음
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // M개의 원소에 대해 이진탐색 실행
        // Arrays.binarySearch(배열, 찾을 값)
        // 존재하면 인덱스 반환
        // 존재하지 않으면 음수 반환
        for (int i = 0; i < M; i++) {
            bw.write(Arrays.binarySearch(A, numbers[i]) >= 0 ? "1" : "0");
            bw.write("\n");
        }

        // 이진 탐색을 사용함으로써 M * logN = 500,000번의 연산으로 획기적으로 줄이게 됨
        bw.close();
        br.close();
    }
}