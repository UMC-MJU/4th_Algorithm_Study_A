import java.util.PriorityQueue;

class 디펜스_게임 {

    // 24.05.08 (수)
    // 처음에는 재귀 (단순한 배낭 문제 등), 2차원 DP를 생각했었음
    // https://velog.io/@saint6839/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%ED%8E%9C%EC%8A%A4-%EA%B2%8C%EC%9E%84를 참고하여 우선순위 큐를 적용해야 함을 알게 됨
    // 문제에서 요구하는 바에 대해서만 풀려고 해야 답에 근접한 사고를 할 수 있을 것 같다.

    public int solution(int n, int k, int[] enemy) {
        // k보다 enemy가 적다면 enemy 길이 리턴 (알고 있던 사항)
        if (k >= enemy.length) {
            return enemy.length;
        }

        // 그 이외의 경우에는 우선순위 큐를 이용 (몰랐던 부분, 재귀 or 2차원 DP만 생각했었음)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]); // 전부 다 queue에 담아둔다.
            if (queue.size() > k) {
                // queue의 사이즈가 k보다 크다는 것은, k만큼 쓰더라도 다 처리할 수 없음을 의미
                // k만큼만 있다면 전부 다 무적권을 이용하여 제거할 수 있음. 그렇기에 k개는 기본적으로 무적권을 사용한다고 가정함 (직접 k에 대해 관리할 필요 X)
                int removeEnemy = queue.poll(); // 제거해야 할 minimum enemy
                if (n < removeEnemy) { // 만약 제거해야 할 minimum enemy보다 n이 작다면 그 지점이 최대 지점임
                    return i;
                }
                n -= removeEnemy; // 그 경우가 아니라면 n에서 minimum enemy를 제거시킴
            }
        }
        return enemy.length;
    }
}
