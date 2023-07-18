import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열을 이끌어내다보면 사실상 피보나치와 같다.
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        if (N >= 2) { // IndexError가 나지 않도록 주의해야 한다. 1 <= N <= 1,000,000이기 때문이다.
            arr[2] = 2;
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746; // 단, 매번 저장할 때 마다 15746으로 나눈 값을 저장해야 한다.
            }
        }
        bw.write(arr[N] + "");

        bw.close();
        br.close();
    }
}