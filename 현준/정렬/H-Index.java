import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for (int t = 0; t <= citations[citations.length - 1]; t++) {
            if (getLowerCount(citations, t) <= t && getUpperCount(citations, t) >= t) {
                result = Math.max(t, result);
            }
        }
        return result;
    }
    public int getLowerCount(int[] citations, int target) {
        int count = 0;
        for (int citation : citations) {
            if (citation <= target) {
                count++;
            }
        }
        return count;
    }
    public int getUpperCount(int[] citations, int target) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= target) {
                count++;
            }
        }
        return count;
    }
}

/*
[1, 4, 5]: 2
[5, 6, 7]: 3
*/