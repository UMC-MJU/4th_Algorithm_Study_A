import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        int low = 1;		// 최소 거리가 가질 수 있는 최솟값
        int high = house[N - 1] - house[0] + 1;	// 최소 거리가 가질 수 있는 최댓값 (Upper bound는 찾고자 하는 값을 초과하는 첫 번째 인덱스를 의미하기 때문에 Upper bound가 가질 수 있는 최댓값은 +1 해줘야 함)
        while(low <= high) {	// Upper Bound 형식
            int mid = (high + low) / 2;
            /*
             * mid 거리에 대해 설치 가능한 공유기 개수가 M 개수에 못 미치면
             * 거리를 좁혀야 하기 때문에 high 를 줄인다. (공유기 갯수는 M개로 정해져 있는데 그것에 못 채워진다는 뜻이므로 좁혀야 한다.)
             */
            if(installCount(mid) < M) {
                high = mid - 1;
            }
            else {
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
                 * 찾아낸다.
                 */
                low = mid + 1;
            }
        }
        /*
         *  Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
         *  1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
         */
        System.out.println(low - 1);
    }
    // distance에 대해 설치 가능한 공유기 개수를 찾는 메소드
    public static int installCount(int distance) {
        int count = 1;
        int lastLocate = house[0]; // 처음 설치 위치는 첫 인덱스
        for (int i = 1; i < house.length; i++) {
            int locate = house[i]; // 다음 지점
            if (locate - lastLocate >= distance) { // 다음 지점 - 마지막 설치 지점의 거리가 distance보다 크거나 같으면 커버 가능하다는 뜻
                count++; // 카운트를 늘리고
                lastLocate = locate; // 마지막 설치 지점을 해당 지점으로 재설정
            }
        }
        return count; // 공유기 설치 갯수 반환
    }
}