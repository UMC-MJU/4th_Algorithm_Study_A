import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num + 1));
            } else {
                map.put(num, 1);
            }
        }
        // 뽑아야 하는 갯수가 key의 갯수보다 크거나 같다면 key의 갯수 리턴 (표현할 수 있는 최대가 key의 갯수이므로) -> 2번, 3번
        if (nums.length / 2 >= map.keySet().size()) {
            return map.keySet().size();
        } else {
            // 뽑아야 하는 갯수가 key의 갯수보다 작다면 뽑아야 하는 갯수 리턴 (key의 갯수는 충분하기 때문) -> 1번
            return nums.length / 2;
        }
    }
}