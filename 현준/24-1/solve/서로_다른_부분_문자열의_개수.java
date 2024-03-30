package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String input = r.readLine();
        char[] s = input.toCharArray();
        HashSet<String> result = new HashSet<>();
        // size: 1000 (즉, O(N^2) 가능)
        for (int size = 1; size < s.length; size++) {
            for (int i = 0; i < s.length; i++) {
                String make = make(i, size, s);
                if (make.equals("NOT")) {
                    result.add(input);
                    continue;
                }
                result.add(make);
            }
        }
        System.out.println(result.size());
    }

    private static String make(int index, int size, char[] s) {
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < index + size; i++) {
            if (s.length < index + size) {
                return "NOT";
            }
            builder.append(s[i]);
        }
        return builder.toString();
    }
}
