package BOJ.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        int numSwitch = Integer.parseInt(br.readLine());
        int[] switchArr = new int[numSwitch + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numSwitch; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int numStudent = Integer.parseInt(br.readLine());
        for (int i = 0; i < numStudent; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int numGiven = Integer.parseInt(st.nextToken());

            switch (gender) {
                case 1:  // 남자인 경우
                    // 남학생은 자기 번호의 배수 번호의 스위치를 바꾼다. 스위치 번호 범위 안에서.
                    for (int j = 1; numGiven * j <= numSwitch; j++) {
                        switchArr[numGiven * j] = onoff(switchArr[numGiven * j]);
                    }
                    continue;

                case 2:  // 여자인 경우
                    // 여학생은 자기 번호와 양쪽 스위치의 번호가 같으면 바꾼다. 최대로.
                    switchArr[numGiven] = onoff(switchArr[numGiven]);
                    for (int k = 1; 0 < numGiven - k && numGiven + k <= numSwitch; k++) {
                        if (switchArr[numGiven - k] == switchArr[numGiven + k]) {
                            switchArr[numGiven - k] = onoff(switchArr[numGiven - k]);
                            switchArr[numGiven + k] = onoff(switchArr[numGiven + k]);
                        }
                        else break; // 좌우 대칭이 아닐 시 꼭 빠져나와야 함.
                    }
            }
        }
        int numOneline = 0;
        for (int i = 1; i <= numSwitch; i++) {
            if (numOneline == 20) {
                System.out.println(); // 줄 개행
                numOneline = 0; // 다시 0으로 초기화
            }
            System.out.print(switchArr[i] + " ");
            numOneline++;

        }
        br.close();
    }

    // on/off 스위치 함수
    public static int onoff(int target) {
        return (target == 0) ? 1 : 0;
    }
}
