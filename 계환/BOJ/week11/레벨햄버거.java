package BOJ.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 레벨햄버거 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

}

// 레벨-L 버거는 번, 레벨(L-1) 버거, 패티, 레벨(L-1)버거, 번으로 이루어져 있다
//// 레벨 0 = 패티
//// 레벨 1 = 번 (패티) 패티 (패티) 번
//BPPPB
//// 레벨 2 = 번 (번 패티 패티 패티 번) 패티 (번 패티 패티 패티 번) 번
//BBPPPBPBPPPBB
//// 레벨 3 = 번 (번 (번 패티 패티 패티 번) 패티 (번 패티 패티 패티 번) 번) 패티 (번 (번 패티 패티 패티 번) 패티 (번 패티 패티 패티 번) 번) 번
//BBBPPPBPBPPPBBPBBPPPBPBPPPBBB
//// 레벨 N 버거를 아래 X장을 먹었을 때, 먹은 패티는 몇장일까?
//// N X
//// 2 7 - 4
//// 1 1 - 0
//// 50
