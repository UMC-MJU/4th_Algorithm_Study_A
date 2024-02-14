package BOJ.겨울방학5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 결혼식_5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 동기의 수
        int m = Integer.parseInt(br.readLine()); // 리스트의 수
        List<Integer> friend = new ArrayList<>(); // 상근이의 친구
        List<Integer> friendFriend = new ArrayList<>(); // 상근이의 친구의 친구
        int answer = 0;

        for (int i = 0; i < m; i++) { // 리스트만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            if (one == 1) { // 상근이
                friend.add(two);
                continue;
            }
            if (two == 1) {
                friend.add(one);
                continue;
            }
            // 상근이 아닌경우
            if (friend.contains(one) && !friend.contains(two)) {  // 상근이의 친구 -> 친구의 친구 가능성
                friendFriend.add(two);
                continue;
            }
            if (friend.contains(two) && !friend.contains(one)) {
                friendFriend.add(one);
            }
        }
        answer = friend.size() + friendFriend.size();
        System.out.println(answer);
    }
}
