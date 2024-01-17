package BOJ.겨울방학4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int count = 0;
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                set.remove(str);
            }
            set.add(str);
        }
        for (String str : set) {
            System.out.println(str);
            count++;
            if (count == K) {
                break;
            }
        }
    }
}
