package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 체스판다시칠하기 {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) {

    }

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        reader.close();
        writer.close();
    }
}
