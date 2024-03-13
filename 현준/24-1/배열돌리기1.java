package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {

    private static int height;
    private static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());
        int rotate = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = 0; i < rotate; i++) {
            int startH = 0;
            int endH = height - 1;
            int startW = 0;
            int endW = width - 1;
            while (startW < endW && startH < endH) {
                map = change(map, startH, startW, endH, endW);
                startW += 1;
                startH += 1;
                endW -= 1;
                endH -= 1;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        reader.close();
    }

    private static int[][] change(final int[][] map, int startH, int startW, int endH, int endW) {
        int[][] clone = new int[height][width];
        for (int i = 0; i < height; i++) {
            clone[i] = map[i].clone();
        }
        for (int h = startH; h <= endH; h++) {
            if (h + 1 <= endH) {
                clone[h + 1][startW] = map[h][startW];
            }
            for (int w = startW; w <= endW; w++) {
                if (w > startW && h == startH) {
                    clone[h][w - 1] = map[h][w];
                }
                if (w + 1 <= endW && h == endH) {
                    clone[h][w + 1] = map[h][w];
                }
            }
            if (h > startH) {
                clone[h - 1][endW] = map[h][endW];
            }
        }
        return clone;
    }
}
