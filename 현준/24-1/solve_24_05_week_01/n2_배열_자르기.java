class n2_배열_자르기 {

    // 24.04.30 (화)
    // 간신히 풀게 된 문제
    // long이 껴있으면 시간 초과가 걸릴 수 있다는 사실을 알게 되었다.

    private static int N;

    public int[] solution(int n, long left, long right) {
        N = n;

        /*
        기존 접근 코드 (시간, 메모리 초과)
        int[][] arr = new int[n][n]; // n행 n열 크기의 배열
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1); // -1로 초기화 (비어있음 표시)
        }

        // O(N^3) => 시간 초과 (n 최대 천만)
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == -1 && i - 1 >= j && i - 1 >= k) {
                        arr[j][k] = i; // 1행 1열 ~ i행 i열 중 비어있는 칸을 i로 채움
                    }
                }
            }
        }

        // 각 행을 잘라내어 모두 이어붙인 배열 만듦 => 메모리 초과
        int[] answer = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[index] = arr[i][j];
                index++;
            }
        }

        int size = (int) (right - left + 1); // right - left < 10^5 (100,000)
        int[] result = new int[size];

        for (int i = (int) left; i <= (int) right; i++) {
            result[i - (int) left] = answer[i];
        }

        return result;
        */

        int[] result = new int[(int) (right - left) + 1];
        int index = 0;

        for (long i = left; i <= right; i++) {
            int groupIndex = group(i);
            result[index] = get(i, groupIndex);
            index++;
        }

        return result;
    }

    // 그룹 인덱스 계산 함수
    private int group(long index) {
        return (int) (index / N);
    }

    // 그룹 안에서 구체적인 수를 제공하는 함수
    private int get(long index, int group) {
        if (group == N - 1) { // 맨 마지막 행의 원소는 전부 N
            return N;
        }
        if (index >= Integer.MAX_VALUE) { // 시간 초과 원인: index가 int 최대 범위를 넘을 때만 long 적용해야 함
            long position;
            if (group == 0) {
                position = index;
            } else {
                position = index % ((long) N * group); // (long)을 하지 않으면 범위 이상
            }

            if (position <= group) {
                return group + 1; // r번째 그룹에서는, r+1이 r+1 만큼 채워져있다. (ex: 1번째 그룹에는 2가 2개 있음)
            }

            long distance = position - group; // 시작점으로부터 더 나아가야 할 사이즈
            int value = group + 1; // 시작 값 (ex: 0번 그룹에서는 시작값이 1부터 됨)

            /*
            시간 초과 원인: for문 + long 조합..
            for (long i = 0; i < distance; i++) {
                value++;
            }
            */
            value += (int) distance; // 개선: 그냥 바로 distance만큼 더하면 됨
            return value;
        }

        // index < Integer.MAX_VALUE 경우
        int pos; // 그룹 안에서의 상대적 인덱스 구하기 (ex: 10 % (4 * 2) = 2)
        if (group == 0) {
            pos = (int) index;
        } else {
            pos = (int) index % (N * group);
        }

        if (pos <= group) {
            return group + 1; // r번째 그룹에서는, r+1이 r+1 만큼 채워져있다. (ex: 1번째 그룹에는 2가 2개 있음)
        }

        int distance = pos - group; // 시작점으로부터 더 나아가야 할 사이즈
        int value = group + 1; // 시작 값 (ex: 0번 그룹에서는 시작값이 1부터 됨)
        for (int i = 0; i < distance; i++) {
            value++;
        }
        return value;
    }
}
