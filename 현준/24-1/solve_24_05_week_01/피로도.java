class 피로도 {

    // 24.04.29 (월)
    // 던전 갯수가 최대 8가지이기 때문에 가능한 경우의 수는 8! = 40,320
    // 만약 최대 갯수가 매우 컸다면 - DP로 풀어야 했으나, 그 방법이 아직 익숙치 않음
    // 추가적으로 공부하려면 DP도 복습해야 할 듯함 (배낭 문제 유형)

    static int[][] temp;
    static int[][] arr;
    static boolean[] used;
    static int now;
    static int answer = -1;

    public int solution(int k, int[][] dungeons) {
        arr = new int[dungeons.length][2];
        // 배열 static으로 복사해두기: 2차원 배열 복사 더 쉬운 방법은? - for문 + 1차원 배열 clone
        for (int i = 0; i < dungeons.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = dungeons[i][j];
            }
        }
        temp = new int[dungeons.length][2]; // 던전 순서 배열
        now = k; // k static
        used = new boolean[dungeons.length]; // for backtracking
        backtracking(0); // backtracking
        return answer; // return answer
    }

    private void backtracking(int depth) {
        if (depth == arr.length) { // for backtracking stop, max value update
            collect(now, temp);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) { // for backtracking 중복 방지
                continue;
            }
            used[i] = true; // for backtracking 중복 방지
            for (int j = 0; j < 2; j++) { // 순서 맞추기
                temp[depth][j] = arr[i][j];
            }
            backtracking(depth + 1); // backtracking recall
            used[i] = false; // for backtracking
        }
    }

    private void collect(int k, int[][] temp) {
        int count = 0; // 가능 횟수
        for (int[] t : temp) {
            // t[0]: 최소 필요 피로도
            // t[1]: 소모 피로도
            if (k < t[0]) {
                break;
            }
            k -= t[1];
            count++;
        }
        answer = Math.max(answer, count); // answer 갱신
    }
}
