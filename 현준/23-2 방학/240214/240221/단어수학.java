import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 단어수학 {

    private static int N;
    private static int result;
    private static String[] inputs;
    private static int[] temp;
    private static boolean[] used;
    private static HashSet<String> alphabets;
    private static HashMap<String, Integer> info;

    // 시도했던 코드 (그리디) - 너무 복잡, 반례 발생
    /*
    private static HashMap<String, Integer> count; // 등장 횟수
    private static HashMap<String, Integer> order; // 순서 (일, 십, 백, 천..)
    private static HashMap<String, Integer> result;
    private static HashMap<String, Alphabet> map;
    private static String[] inputs;
    private static Alphabet[] alphabets;
    private static ArrayList<Alphabet> list;

    private static class Alphabet implements Comparable<Alphabet> {
        private String value;
        private int count;
        private int order;

        public Alphabet(final String value, final int count, final int order) {
            this.value = value;
            this.count = count;
            this.order = order;
        }

        @Override
        public int compareTo(final Alphabet other) {
            // 10의 제곱으로 계산해보기
            int otherResult = (int) Math.pow(10, other.order) * other.count;
            int myResult = (int) Math.pow(10, this.order) * this.count;
            return Integer.compare(otherResult, myResult);
        }

        @Override
        public String toString() {
            return "Alphabet{" +
                    "value=" + value +
                    ", count=" + count +
                    ", order=" + order +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine()); // 1 <= N <= 10
        alphabets = new Alphabet[N];

        count = new HashMap<>();
        order = new HashMap<>();
        result = new HashMap<>();
        list = new ArrayList<>();
        map = new HashMap<>();
        inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = reader.readLine();
            String[] input = inputs[i].split("");
            for (int j = 0; j < input.length; j++) {
                if (!count.containsKey(input[j])) {
                    count.put(input[j], 1);
                } else {
                    count.put(input[j], count.get(input[j]) + 1);
                }

                if (!order.containsKey(input[j])) {
                    order.put(input[j], input.length - j - 1);
                } else {
                    order.put(input[j], Math.max(order.get(input[j]), input.length - j - 1));
                }
            }
        }

        for (String s : count.keySet()) {
            list.add(new Alphabet(s, count.get(s), order.get(s)));
        }
        alphabets = new Alphabet[list.size()];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = list.get(i);
        }

        Arrays.sort(alphabets);

        System.out.println(Arrays.toString(alphabets));

        int number = 9;
        for (Alphabet a : alphabets) {
            result.put(a.value, number);
            number--;
        }

        int answer = 0;
        for (String input : inputs) {
            answer += calculateNumber(input);
        }

        writer.write(answer + "");
        writer.close();
        reader.close();
    }

    private static int calculateNumber(final String input) {
        String[] numberValues = input.split("");
        StringBuilder builder = new StringBuilder("");
        for (String s : numberValues) {
            // System.out.print(result.get(s));
            builder.append(result.get(s));
        }
        // System.out.println();
        return Integer.parseInt(builder.toString());
    }

     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        result = 0;

        N = Integer.parseInt(reader.readLine());
        inputs = new String[N];
        used = new boolean[10];
        alphabets = new HashSet<>();
        info = new HashMap<>();

        for (int i = 0; i < N; i++) {
            inputs[i] = reader.readLine();
            String[] row = inputs[i].split("");
            alphabets.addAll(Arrays.asList(row));
        }

        for (String alphabet : alphabets) {
            info.put(alphabet, 0);
        }

        temp = new int[alphabets.size()];
        backtracking(0);
        writer.write(result + "");
        writer.close();
        reader.close();
    }

    private static void backtracking(int depth) {
        if (depth == alphabets.size()) {
            print();
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp[depth] = i;
            backtracking(depth + 1);
            used[i] = false;
        }
    }

    private static void print() {
        int index = 0;
        for (String alphabet : alphabets) {
            info.put(alphabet, temp[index]);
            index++;
        }
        result = Math.max(convert(), result);
    }

    private static int convert() {
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        for (String input : inputs) {
            String[] row = input.split("");
            for (String r : row) {
                builder.append(info.get(r));
            }
            sum += Integer.parseInt(builder.toString());
            builder = new StringBuilder();
        }
        return sum;
    }
}
