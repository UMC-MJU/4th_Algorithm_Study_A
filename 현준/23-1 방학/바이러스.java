import java.io.*;
import java.util.*;
public class Main {

    static int result = 0; // 최종 결과
    static StringTokenizer st; // 자주 쓸 StringTokenizer
    static int start; // 자주 쓸 출발지
    static int dest; // 자주 쓸 목적지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computers = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int links = Integer.parseInt(br.readLine()); // 링크 수
        int[] visited = new int[computers + 1]; // 방문 여부 (1번 컴퓨터는 [1]에 저장되게 하므로 computers + 1)

        Map<Integer, ArrayList<Integer>> info = new HashMap<>(); // 전체적인 정보를 나타냄 (1번 컴퓨터가 가지고 있는 목록, 2번 컴퓨터가 가지고 있는 목록..)
        for (int i = 1; i <= computers; i++) {
            info.put(i, new ArrayList<>()); // 각 컴퓨터는 빈 배열을 가지고 있도록 함
        }

        for (int i = 0; i < links; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 받고
            start = Integer.parseInt(st.nextToken()); // 출발지 받고
            dest = Integer.parseInt(st.nextToken()); // 목적지 받으면
            ArrayList<Integer> prevStart = info.get(start); // 출발지가 가지고 있는 인접한 리스트 목록 받고
            ArrayList<Integer> prevDest = info.get(dest); // 목적지가 가지고 있는 인접한 리스트 목록을 받아서
            prevStart.add(dest); // 리스트에 목적지를 추가해주고
            prevDest.add(start); // 여기에도 리스트에 출발지를 추가해준다.
            info.put(start, prevStart);
            info.put(dest, prevDest);
        }
        bfs(info, 1, visited); // 주어진 정보들을 기반으로 BFS를 돌린다. 시작은 1에서부터임
        bw.write(result - 1 + ""); // 자신이 포함되기 때문에 -1을 한다.
        bw.close();
        br.close();
    }

    public static void bfs(Map<Integer, ArrayList<Integer>> info, int from, int[] visited) {
        visited[from] = 1; // 순환을 방지하기 위해 자신을 방문했다고 표시
        ArrayDeque<Integer> queue = new ArrayDeque<>(); // BFS 위한 큐
        queue.addLast(from); // 시작점 넣고
        while (!queue.isEmpty()) {
            int select = queue.pollFirst(); // 인접한 컴퓨터를 만날 때 마다
            result++; // result 1씩 증가 (ex: 1번 컴퓨터가 2, 3, 5 컴퓨터와 연결되어 있을 때 처음 2 만나면 result가 1 증가됨)
            ArrayList<Integer> list = info.get(select); // 인접한 컴퓨터가 가지고 있는 그 컴퓨터만의 리스트 (위의 예시에서는 2번 컴퓨터가 가지고 있는 목록)
            for (Integer node : list) {
                if (visited[node] == 1) // 이미 방문했던 컴퓨터의 경우에는 스킵해야 함
                    continue;
                visited[node] = 1; // 그런 경우가 아니면 방문 처리해주고
                queue.addLast(node); // 해당 컴퓨터를 큐에 넣어줘야 함 (ex: 1번 컴퓨터가 2번 컴퓨터를 만났고, 2번 컴퓨터는 5번 컴퓨터와 연결되어 있다면 5번이 저장됨)
            }
        }
    }
}
