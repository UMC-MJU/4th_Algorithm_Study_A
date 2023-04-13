class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, target);
    }
    public int dfs(int calculated, int[] remain, int target) {
        if (remain.length == 0) { // 남은 배열 요소가 없다면 일치할 경우에만 1 리턴
            return calculated == target ? 1 : 0;
        }
        int temp = remain[0]; // 매번 배열의 첫 번째 인덱스 값을 가져옴
        int[] next = new int[remain.length - 1];
        /*
        for (int i = 0; i < next.length; i++) {
            next[i] = remain[i + 1];
        }
        */
        System.arraycopy(remain, 1, next, 0, next.length); // 배열 복사 방법 메서드 익숙해지도록 하기
        // 첫 번째 인자: 복사할 배열
        // 두 번째 인자: 복사를 시작할 위치
        // 세 번째 인자: 붙여넣을 배열
        // 네 번째 인자: 붙여넣을 시작 위치
        // 다섯 번째 인자: 시작 위치부터 몇 번째까지 복사할 것인지
        return dfs(calculated + temp, next, target) + dfs(calculated - temp, next, target); // 각 경우는 +를 선택한 경우와 -를 선택한 경우로 나뉜다
    }
}