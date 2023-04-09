import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder("");
        String[] values = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            values[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(values, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        if (values[0].equals("0")) return "0";
        for (String v : values) {
            sb.append(v);
        }
        return sb.toString();
    }
}