import java.time.LocalDate;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // term을 hashmap 형태로 저장하기
        for (String term : terms) {
            StringTokenizer st = new StringTokenizer(term);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        String[] token = parseStringToDateToken(today); // 2022.10.24 -> [2022, 10, 24]
        LocalDate now = generateLocalDate(token[0], token[1], token[2]); // Localdate.of(2022, 10, 24)
        int count = 1; // 인덱스 처리

        for (String privacy : privacies) {
            StringTokenizer st = new StringTokenizer(privacy);
            String[] day = parseStringToDateToken(st.nextToken());
            int month = map.get(st.nextToken()); // map.get("A") 등등
            LocalDate test = generateLocalDate(day[0], day[1], day[2]); // LocalDate로 변환
            if (!test.plusMonths(month).isAfter(now)) // 만약 month만큼 더했는데 그게 now보다 이후가 아니라면 - 만료된 것
                list.add(count); // 조건 충족 시 인덱스 넣어줌
            count++;
        }
        return list.stream().mapToInt(i -> i).toArray(); // int[] 반환
    }

    // year.month.day를 . 단위로 나눌 때, split(".")로 하면 인식을 하지 못한다. 정규 표현식을 써야만 한다.
    private String[] parseStringToDateToken(String day) {
        return day.split("\\.");
    }

    // year, month, day를 받아 LocalDate로 파싱하는 함수
    private LocalDate generateLocalDate(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }
}