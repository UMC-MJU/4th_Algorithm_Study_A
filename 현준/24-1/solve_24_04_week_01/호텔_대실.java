import java.util.ArrayList;
import java.util.Arrays;

class 호텔_대실 {

    // 24.04.01 (월)

    public static class Time implements Comparable<Time> {
        String start; // 시작 시간
        String end; // 종료 시간

        public Time(String[] input) { // 입력 구성: ["HH:MM", "HH:MM"]
            this.start = input[0];
            this.end = input[1];
        }

        // 알게 된 점: 문자열 사전 순 비교는 {문자열}.compareTo{문자열}
        // {문자열}.compareTo{문자열} < 0 = 첫 번째 문자열이 두 번째 문자열보다 사전 순으로 빠르다
        // {문자열}.compareTo{문자열} == 0 = 첫 번째 문자열과 두 번째 문자열이 사전 순으로 같다
        // {문자열}.compareTo{문자열} > 0 = 첫 번째 문자열이 두 번째 문자열보다 사전 순으로 느리다

        // 문제를 풀려면 순서대로 진행해야 한다. 따라서 정렬 기준을 정한다.
        @Override
        public int compareTo(Time other) {
            if (start.compareTo(other.start) == 0) { // 시작 시간이 같다면
                return end.compareTo(other.end); // 끝나는 시간이 빠른 순서대로 정렬한다.
            }
            return start.compareTo(other.start); // 그렇지 않다면 시작 시간이 빠른 순서대로 정렬한다.
        }
    }

    public int solution(String[][] book_time) {
        ArrayList<ArrayList<Time>> times = new ArrayList<>();
        // ArrayList<ArrayList<>> 구조를 만든다. "방"을 일종의 "대기열"로 만들기 위함이다.
        Time[] timeArr = new Time[book_time.length]; // 일단 입력된 book_time을 Time 배열로 파싱한다.
        for (int i = 0; i < timeArr.length; i++) { // O(N) -> 1000개
            timeArr[i] = new Time(book_time[i]);
        }
        Arrays.sort(timeArr); // 정렬 기준에 맞추어 정렬한다. // O(NlogN)
        for (Time t : timeArr) {
            logic(times, t); // logic을 돌린다. // 전체 시간 복잡도: O(N^2)
        }

        // 시간 복잡도가 통과된 이유는 ArrayList<ArrayList<Time>> times가 최대 1000이기 때문에 그런 것 같다. (겉에가 1000개면 내부 ArrayList가 1개씩이라는 의미이므로)

        /*
        결과 검증용 출력
        for (ArrayList<Time> time : times) {
            System.out.println("=====");
            for (Time t : time) {
                System.out.println(t.start + " " + t.end);
            }
        }
         */

        return times.size(); // 방 (대기열)의 사이즈를 리턴한다.
    }

    private void logic(ArrayList<ArrayList<Time>> times, Time time) {
        if (times.isEmpty()) { // 대기열이 아예 없다면 방 (대기열)을 만들고 리턴하면 된다.
            ArrayList<Time> list = new ArrayList<>();
            list.add(time);
            times.add(list);
            return;
        }
        boolean find = false; // 대기열들을 돌았을 때 가능한 방이 있는지 여부를 나타낸다.
        for (ArrayList<Time> t : times) {
            if (t.isEmpty()) { // 비어있는 대기열은 넘긴다.
                continue;
            }
            Time last = t.get(t.size() - 1); // 그렇지 않다면, 마지막 시간을 구한다. (정렬되어 있기 때문에 마지막 값을 꺼낸다.)
            // 여기가 시간이 걸렸던 부분 (반례 부분) - 최소 10분이 필요하다. 딱 10분이 걸렸을 때는 괜찮다.
            if (last.end.compareTo(time.start) <= 0 && !find) {
                int lastHour = Integer.parseInt(last.end.split(":")[0]);
                int timeHour = Integer.parseInt(time.start.split(":")[0]);
                int lastMin = Integer.parseInt(last.end.split(":")[1]);
                int timeMin = Integer.parseInt(time.start.split(":")[1]);

                /*
                if (lastHour == 0) { 마지막 시간에 대해서는 변환을 하지 않아야 문제가 발생하지 않는다. WHY?
                    lastHour = 24;
                }

                last: 00:23 -> 24 * 60 + 23 = 1463 // 원래 더 적어야 하는데도, time보다 더 큰 값으로 되기 때문이다.
                time: 01:25 -> 01 * 60 + 24 = 84
                */

                lastMin = lastHour * 60 + lastMin; // 시간으로 파싱한다.
                if (timeHour == 0) { // 이후 시간이 00시라면 시간을 24시로 한다. (last 날짜가 23시일 경우 등에, 조정을 해야 하기 때문이다.)
                    timeHour = 24;
                }
                timeMin = timeHour * 60 + timeMin;
                if (lastMin + 10 > timeMin) { // 시간이 10분 지나지 않았다면 새로운 방으로 이동시켜야 한다. (ex: lastMin 5, timeMin 8)
                    continue;
                }

                t.add(time);
                find = true;
            }
        }
        if (!find) { // 가능한 방이 아예 없는 경우에만 새 방 (대기열)을 만들고 그곳에 시간을 넣는다.
            ArrayList<Time> list = new ArrayList<>();
            list.add(time);
            times.add(list);
        }
    }
}
