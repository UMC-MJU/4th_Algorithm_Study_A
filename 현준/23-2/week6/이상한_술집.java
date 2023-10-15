import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이상한_술집 {

    private static BufferedReader reader;
    private static BufferedWriter writer;
    private static long[] kettles; // 주전자 배열
    private static int kettle; // 주전자 수
    private static int person; // 사람 수
    private static long maxKettle; // 최대 주전자에 담긴 용량

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        kettle = Integer.parseInt(tokenizer.nextToken());
        maxKettle = Integer.MIN_VALUE;
        kettles = new long[kettle];
        person = Integer.parseInt(tokenizer.nextToken());
        storeAlcholInKettles(); // 주전자에 술 저장
        writer.write(binary() + ""); // 출력
        close();
    }

    private static void storeAlcholInKettles() throws IOException {
        for (int i = 0; i < kettle; i++) {
            kettles[i] = Long.parseLong(reader.readLine());
            maxKettle = Math.max(kettles[i], maxKettle);
        }
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static long binary() {
        long start = 0;
        long end = maxKettle; // 나눠줄 수 있는 값은 0 ~ 최대 주전자에 담긴 술 용량
        if (maxKettle == 1) {
            return 1; // 반례로 [1 1 100]이 들어왔을 때 0이 나오는 문제 발생 - 특이한 케이스라 이 부분만 1을 리턴했습니다.
        }
        while (start <= end) { // start와 end가 같아질 때 까지 반복해야 합니다. 이 조건을 적용하냐 안적용하냐가 참 까다로운 것 같습니다.
            long mid = (start + end) / 2;
            long canPerson = calculatePersonAllKettle(mid); // 각 주전자에서 mid만큼 배분했을 때 얻을 수 있는 인원을 구합니다.
            if (canPerson >= person) { // 인원이 실제보다 같거나 크다면 더 나누어줄 수 있는지 해봐야 하므로 mid를 증가시킵니다.
                start = mid + 1;
            } else { // 인원이 실제보다 작다면 1인당 용량을 줄여야 합니다.
                end = mid - 1;
            }
        }
        return start < 1 ? 0 : start - 1; // 만약 start가 1 미만이라면 그냥 0을 리턴하고, 그렇지 않다면 start - 1을 합니다.
    }

    // 네이밍 고민을 더 해야 할 것 같습니다.
    // calculateMaxPersonEachAlchol 메서드를 전부 돌립니다.
    private static long calculatePersonAllKettle(long alchol) {
        long sum = 0;
        for (long kettle : kettles) {
            sum += calculateMaxPersonEachAlchol(kettle, alchol);
        }
        return sum;
    }

    // 네이밍 고민을 더 해야 할 것 같습니다.
    // 각 주전자에 담긴 술을 특정 술 용량으로 나눌 때의 몫을 구합니다.
    private static long calculateMaxPersonEachAlchol(long kettle, long alchol) {
        if (alchol == 0) { // 만약 나누는 술이 0이라면 그냥 0 리턴
            return 0;
        }
        return kettle / alchol;
    }

    private static void close() throws IOException {
        writer.close();
        reader.close();
    }
}
