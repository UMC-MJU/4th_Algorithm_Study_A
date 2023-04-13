import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 가장 짧은 방식: BFS 권장
        // Arrays.asList와 contains 메서드 공부 필요
        boolean existed = new ArrayList<>(Arrays.asList(words)).contains(target);
        if (!existed) {
            return 0; // 아예 없다면 0 리턴
        }
        HashMap<String, ArrayDeque<String>> graph = new HashMap<>(); // 연결 관계 나타낸 그래프
        HashMap<String, Integer> visited = new HashMap<>(); // 방문 값 계산용
        visited.put(begin, 1); // begin에 1 넣어서 구별되도록
        ArrayDeque<String> linkWithBegin = new ArrayDeque<>();
        for (String word : words) {
            if (word.equals(begin)) { // begin과 완전히 일치하는 경우는 제외하기
                continue;
            }
            ArrayDeque<String> temp = new ArrayDeque<>();
            visited.put(word, 0); // 각 단어에 대해서는 0 값 가지도록
            if (linked(begin, word)) { // 각 단어와 begin이 연결되어 있는지 검사
                linkWithBegin.addLast(word);
                temp.addLast(begin);
                graph.put(word, temp);
            }
            for (int i = 0; i < words.length; i++) {
                if (!graph.containsKey(words[i])) { // 키가 없다면 새로 만들어주고
                    graph.put(words[i], new ArrayDeque<String>());
                }
                if (linked(word, words[i])) { // 연결되어 있다면 word 키 기준으로만 배열 추가해주기 (2차원이므로 어차피 다시 돌음)
                    ArrayDeque<String> sourceDeque = graph.get(word);
                    sourceDeque.addLast(words[i]);
                    graph.put(word, sourceDeque);
                }
            }
        }
        graph.put(begin, linkWithBegin); // begin과 연결된 것 넣어줌
        return bfs(graph, begin, target, visited);
    }
    public int bfs(HashMap<String, ArrayDeque<String>> graph, String begin, String target, HashMap<String, Integer> visited) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addLast(begin);
        while (!queue.isEmpty()) {
            String temp = queue.pollFirst();
            ArrayDeque<String> nodes = graph.get(temp); // 각 word에 대한 연결 리스트
            for (String node : nodes) {
                if (visited.get(node) != 0) { // 방문했다면 값 제거해주고 스킵
                    nodes.pollFirst();
                    continue;
                }
                queue.addLast(node);
                visited.put(node, visited.get(temp) + 1); // 새로 방문한 것이면 새로 값 설정
                nodes.pollFirst();
            }
        }
        return visited.get(target) - 1; // 시작 값을 1로 했으므로 -1해서 리턴
    }
    public boolean linked(String s1, String s2) { // 연결 기준
        int count = 0;
        String[] s1_arr = s1.split("");
        String[] s2_arr = s2.split("");
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1_arr[i].equals(s2_arr[i])) {
                count++;
            }
        }
        return count == s1.length() - 1;
    }
}