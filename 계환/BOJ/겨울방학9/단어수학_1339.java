package BOJ.겨울방학9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단어수학_1339 {

    private static int N;
    private static String[] arr;
    private static ArrayList<Alphabet> alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int length = word.length();
            for (int j = 0; j < length; j++) {
                char alphabet = word.charAt(j);
                for (Alphabet a : alphabets) {
                    if (a.alphabet == alphabet) {
                        a.updateCount();
                        a.updateMaxDigree(length - j);
                        continue;
                    }
                    alphabets.add(new Alphabet(alphabet, length - j));

                }

            }
            arr[i] = word;
        }
    }

    static class Alphabet {
        char alphabet;
        int maxDegree;
        int count;

        public Alphabet(char alphabet, int maxDegree) {
            this.alphabet = alphabet;
            this.maxDegree = maxDegree;
            this.count = 1;
        }
        public void updateMaxDigree(int degree) {
            this.maxDegree = Math.max(this.maxDegree, degree);
        }

        public void updateCount() {
            this.count++;
        }
    }
}
