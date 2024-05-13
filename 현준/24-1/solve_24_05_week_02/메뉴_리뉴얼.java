import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class 메뉴_리뉴얼 {

    // 24.05.11 (토)
    // 답안 참고하여 제출
    // 주석은 실패했던 코드 (50% 정답)
    
    static HashMap<String,Integer> map;

    public static void combi(String str,StringBuilder sb,int idx, int cnt, int n){
        if(cnt == n) {
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        for(int i = idx ; i<str.length();i++){
            sb.append(str.charAt(i));
            combi(str,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);
        }
    }

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for(int i =0;i<course.length;i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(int j =0;j<orders.length;j++){
                StringBuilder sb = new StringBuilder();
                if(course[i]<=orders[j].length())
                    combi(orders[j],sb,0,0,course[i]);
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());

            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);

        return answer;
    }
    /*
    실패했던 코드

    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.HashSet;

class Solution {

    private static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word other) {
            return Integer.compare(other.count, this.count);
        }

        @Override
        public String toString() {
            return "[" + word + " - " + count + "]";
        }
    }

    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 각 문자열마다 사전 순으로 정렬을 해 둔다.
        String[] tokens = orders.clone();
        for (int i = 0; i < tokens.length; i++) {
            String[] row = orders[i].split("");
            tokens[i] = String.join("", row);
        }

        System.out.println(Arrays.toString(tokens));

        // 갯수는 정확하지 않지만, 어쨌든 교집합 조합은 파악됨.
        for (int c : course) {
            for (int i = 0; i < orders.length; i++) {
                for (int j = 0; j < orders.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    String s = subtract(orders[i], orders[j], c);
                    if (s.isEmpty()) {
                        continue;
                    }
                    if (!map.containsKey(s)) {
                        map.put(s, 2);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
        }

        HashMap<String, Integer> result = new HashMap<>(); // 진짜 map
        for (String s : map.keySet()) {
            for (String o : orders) {
                String contain = subtract(s, o, s.length());
                if (contain.equals(s) && !result.containsKey(contain)) {
                    result.put(s, 1);
                } else if (contain.equals(s) && result.containsKey(contain)) {
                    result.put(s, result.get(s) + 1);
                }
            }
        }

        Word[] words = new Word[result.keySet().size()];
        int index = 0;
        for (String s : result.keySet()) {
            words[index] = new Word(s, result.get(s));
            index++;
        }

        Arrays.sort(words);
        // System.out.println(Arrays.toString(words));

        ArrayList<String> answer = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (Word w : words) {
            if (count.containsKey(w.word.length()) && count.get(w.word.length()) == w.count) {
                answer.add(w.word);
            } else if (!count.containsKey(w.word.length())) {
                answer.add(w.word);
                count.put(w.word.length(), w.count);
            }
        }

        HashSet<String> t = new HashSet<>();
        for (String a : answer) {
            String[] row = a.split("");
            Arrays.sort(row);
            t.add(String.join("", row));
        }

        String[] b = new String[t.size()];
        int idx = 0;
        for (String a : t) {
            b[idx] = a;
            idx++;
        }
        Arrays.sort(b);
        return b;
    }

    private String subtract(String s1, String s2, int size) {
        StringBuilder builder = new StringBuilder("");
        String[] s1Token = s1.split("");
        String[] s2Token = s2.split("");
        for (int i = 0; i < s1Token.length; i++) {
            for (String s : s2Token) {
                if (s1Token[i].equals(s) && builder.toString().length() < size) {
                    builder.append(s);
                }
            }
        }
        if (builder.toString().length() != size) {
            return "";
        }
        return builder.toString();
    }
}
     */
}
