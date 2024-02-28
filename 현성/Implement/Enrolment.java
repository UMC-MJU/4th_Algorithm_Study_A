package prePractice;

import java.io.*;
import java.util.*;

public class Enrolment {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/data.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0; i<l; i++) {
            String num = br.readLine();
            if(set.contains(num)) set.remove(num);
            set.add(num);
        }

        for(String ret : set) {
            if(k <= 0)
                break;
            bw.write(ret);
            bw.write("\n");
            k--;
        }

        bw.flush();
        bw.close();

    }
}
