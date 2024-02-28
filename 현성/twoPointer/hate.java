import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class hate {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/data.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       //9
        int K = Integer.parseInt(st.nextToken());       //2


        int left =0;
        int right = -1;
        int [] numCnt = new int[100001];    //입력 예제에서 숫자에 해당하는 개수를 카운트해주는 배열
        int answer =1;

        List<Integer> nums = Arrays.stream(br.readLine().split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        for(int i=0; i<nums.size(); i++){       //입력예제만큼 숫자를 돌리기
            int num = nums.get(i);              //숫자를 꺼내서
            while(numCnt[num] >= K && left < right){    //꺼낸 숫자의 count 횟수를 문제에 주어진 조건과 비교하고 부분수열의 범위를 나타내는 왼쪽 , 오른쪽을 비교합니다.
                numCnt[nums.get(left++)]--;
            }
            numCnt[num]++;
            right++;
            answer = Math.max(right - left + 1, answer);        //인덱스 0은 생각을 하지 않기 때문에 플러스1을 해주고 기존 answer에 저장된 값과 비교하면 최대값 찾기
        }


        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();


    }
}
