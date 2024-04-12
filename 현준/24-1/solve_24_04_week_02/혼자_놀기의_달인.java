import java.util.ArrayList;
import java.util.Arrays;

class 혼자_놀기의_달인 {

    // 24.04.09 (화)

    public int solution(int[] cards) {
        boolean[] opened = new boolean[cards.length + 1]; // 상자 오픈 여부
        int[][] map = new int[cards.length + 1][1]; // 각 카드가 가리키는 상자는 하나만 존재, 그렇기에 2차원 배열에 내부 배열 사이즈를 1로 설정
        for (int i = 1; i <= cards.length; i++) { // "cards[i]는 i + 1번 상자에 담긴 카드에 적힌 숫자를 의미합니다."
            map[i][0] = cards[i - 1]; // 1부터 시작하는 것으로 조정했기 때문에 -1
        }

        /*
        for (int i = 1; i <= cards.length; i++) {
            System.out.println(i + " " + map[i][0]);
        }
        */

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= cards.length; i++) {
            if (!opened[i]) { // 열리지 않았을 때만 그룹에 추가
                result.add(logic(i, map, opened));
            }
        }

        if (result.size() == 1) { // "만약 1번 상자 그룹을 제외하고 남는 상자가 없으면 그대로 게임이 종료되며, 이때 획득하는 점수는 0점입니다."
            return 0;
        }

        int[] answer = result.stream().mapToInt(x -> x).toArray();
        Arrays.sort(answer);

        // "1번 상자 그룹에 속한 상자의 수와 2번 상자 그룹에 속한 상자의 수를 곱한 값이 게임의 점수입니다."
        // "범희가 이 게임에서 얻을 수 있는 최고 점수를 구해서 return 하도록 solution 함수를 완성해주세요."
        return answer[answer.length - 1] * answer[answer.length - 2];
    }

    // 그룹의 갯수 계산 함수
    private int logic(int index, int[][] map, boolean[] opened) {
        int sum = 0;
        int start = index;
        while (!opened[start]) { // 열리지 않았을 때만 계속 진행
            opened[start] = true;
            start = map[start][0]; // ex: 1번 상자에 3이 적혀있으면 3번 상자로 이동
            sum++;
        }
        return sum;
    }
}
