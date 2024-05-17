import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_배정 {

    // 24.05.17 (금)

    private static class Time implements Comparable<Time> {

        int start;
        int end;

        public Time(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Time other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        // PriorityQueue<Time> times = new PriorityQueue<>();
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            Time time = new Time(start, end);
            times[i] = time;
            /*
            처음 시도했던 방식: 우선순위 큐에 시작과 종료를 모두 넣었었다.
            if (times.isEmpty()) {
                times.add(time);
            } else {
                Time peek = times.peek();
                if (peek.end <= time.start && time.start <= time.end) {
                    times.poll();
                    times.add(time);
                } else {
                    times.add(time);
                }
            }
             */
        }
        Arrays.sort(times);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            if (queue.isEmpty()) {
                queue.add(times[i].end);
            } else {
                if (queue.peek() <= times[i].start) {
                    queue.poll();
                }
                queue.add(times[i].end);
            }
        }
        writer.write(queue.size() + "");
        writer.close();
        reader.close();
    }
}
