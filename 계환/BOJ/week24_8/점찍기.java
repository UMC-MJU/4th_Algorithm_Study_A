package BOJ.week24_8;

public class 점찍기 {
    public long solution(long k, long d) {
        long answer = 0;
        for (long i = 0; i <= d; i += k) {
            long maxX = (long) Math.sqrt(d * d - i * i);
            answer += maxX / k + 1;
        }
        return answer;
    }
}
