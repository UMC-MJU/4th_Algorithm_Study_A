\import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입_사원 {

    // 24.04.12 (금)

    // 사람 클래스
    private static class Person implements Comparable<Person> {

        int document; // 서류 순위
        int interview; // 면접 순위

        public Person(final int document, final int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(final Person other) { // 일단 서류 순으로 오름차순 정렬해둔다. (즉, 서류가 더 우수한 사람이 먼저 오도록)
            return Integer.compare(this.document, other.document);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            Person[] persons = new Person[N];

            // initialize
            for (int j = 0; j < N; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int document = Integer.parseInt(tokenizer.nextToken());
                int interview = Integer.parseInt(tokenizer.nextToken());
                persons[j] = new Person(document, interview);
            }
            Arrays.sort(persons); // sort

            ArrayDeque<Person> temp = new ArrayDeque<>();
            for (Person person : persons) {
                if (temp.isEmpty()) { // 비어 있을 경우에는 사람을 저장한다. (서류 1등이니까)
                    temp.addLast(person);
                    continue;
                }
                Person last = temp.peekLast(); // 마지막에 선택한 사람
                // 이미 서류 순으로 정렬되어 있으므로, 면접만 비교하면 된다.
                // 마지막에 선택한 사람의 면접 등수가 새로운 사람의 면접 등수보다 클 경우 (이미 서류는 새로운 사람이 등수가 크므로)에만 담는다.
                if (person.interview < last.interview) {
                    temp.addLast(person);
                }
            }
            writer.write(temp.size() + "\n");
        }

        writer.close();
        reader.close();
    }
}
