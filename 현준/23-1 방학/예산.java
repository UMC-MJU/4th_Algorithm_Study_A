import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        // 지방의 수가 최대 10,000이고
        // 각 지방에 배정된 예산이 1 ~ 100,000 이므로
        // 최악의 경우에는 10,000 x 100,000의 경우의 수가 생길 것이다.
        // 그런데 이진 탐색으로 한다면 10,000 x log(100,000) = 50,000번의 연산으로 충분

        // 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 수 입력 및 도시 배열 정의
        int N = Integer.parseInt(br.readLine());
        int[] cities = new int[N];

        // 도시에 배정된 예산 작성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.parseInt(br.readLine()); // 최대 예산 정의

        Arrays.sort(cities); // 이진 탐색 위해 정렬

        bw.write(binary(cities, max) + ""); // 이진 탐색 결과 출력
        bw.close();
        br.close();
    }

    // 배열의 합을 구하는 함수
    // 평소에는 스트림을 활용해서 빠르게 처리하긴 했지만, 가끔 스트림 때문에 오히려 시간이 더 느린 경우도 있다고 한다.
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 배열을 돌면서 limit보다 큰 경우에는 limit을 더하고, 그렇지 않을 경우에는 해당 값을 더하도록 하여 합산을 한다.
    // 처음에는 메모리 초과가 났었다. 그 이유는 arr 배열을 새로 복사한 뒤 limit보다 크면 원소의 값을 limit으로 설정한 배열을 만들었기 때문이다.
    public static int getBudget(int[] arr, int limit) {
        int sum = 0;
        for (int cost : arr) {
            if (cost > limit) {
                sum += limit;
                continue;
            }
            sum += cost;
        }
        return sum;
    }

    public static int binary(int[] arr, int max) {
        if (getSum(arr) <= max) // max보다 작거나 같으면 단순히 arr의 최댓값을 리턴한다.
            return arr[arr.length - 1];

        // 그렇지 않을 경우에는 1 ~ arr의 최댓값 사이의 값으로 예산을 책정한다.
        int start = 1;
        int end = arr[arr.length - 1]; // 최대 1 ~ 100,000
        int result = 0; // 결괏값

        while (start <= end) {
            int mid = (start + end) / 2; // 사잇값 구하고
            int testBudgetSum = getBudget(arr, mid); // 해당 값으로 합산했을 때

            if (testBudgetSum > max) { // max보다 크다면 - 예산을 줄여야 한다.
                end = mid - 1;
                continue;
            }
            // max보다 작거나 같다면 - start를 이동시킨다. 또한 이때의 mid 값이 result이다.
            result = mid;
            start = mid + 1;
        }

        return result;
    }
}