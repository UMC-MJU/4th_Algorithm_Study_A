import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int idx = commands[i][2] - 1;
            int[] temp = new int[end - start + 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = array[start + j];
            }
            Arrays.sort(temp);
            result[i] = temp[idx];
        }
        return result;
    }
}