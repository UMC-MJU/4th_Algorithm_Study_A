//package BOJ.겨울방학10;
//
//import java.io.*;
//import java.util.*;
//
//public class 소셜네트워크_3098 {
//
//    static int N;
//    static int M;
//    static int K;
//    static ArrayList<Integer> KList = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//    static ArrayList<ArrayList<Integer>> updateList = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i <= N; i++) {
//            list.add(new ArrayList<>());
//            updateList.add(new ArrayList<>());
//        }
//        // 인접 리스트 생성
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int one = Integer.parseInt(st.nextToken());
//            int two = Integer.parseInt(st.nextToken());
//            list.get(one).add(two);
//            list.get(two).add(one);
//            updateList.get(one).add(two);
//            updateList.get(two).add(one);
//        }
//        bfs();
//        System.out.println("K: "+K);
//        for (Integer i : KList) {
//            System.out.println(i);
//        }
//    }
//
//    public static void bfs() {
//        boolean[] fullCheck = new boolean[N + 1];
//        K = 0;
//        // 아래 for문을 몇번 돌았는지 => 모든 사람이 서로 친구가 되는데 며칠이 걸리는지 (K)
//        for (int j = 0; j<5; j++) {
//            // 관계 추가가 완료되었는지 체크
//            int isEnd = 0;
//            for (int i = 1; i<= N; i++) {
//                if (fullCheck[i]) {
//                    isEnd++;
//                    System.out.println("isEnd: " + isEnd);
//                }
//            }
//            if (isEnd == N) {
//                return;
//            }
//            K++;
////            System.out.println("k 추가됨" + K);
//            // 최신화
//            for (int i = 1; i <= N; i++) {
//                list.set(i, new ArrayList<>(updateList.get(i)));
//            }
//
//            int relationshipCount = 0;
//            for (int i = 1; i <= N; i++) {
//                if (list.get(i).size() == N-1){
//                    System.out.println("fullCheck 바꿔줬음!" +  i);
//                    fullCheck[i] = true;
//                }
//                for (int next : list.get(i)) {
//                    for (int check : list.get(next)) {
//                        // check가 list.get(i)에 없다면 추가, 있으면 넘어가기
//                        if (updateList.get(i).contains(check)) continue;
//                        updateList.get(i).add(check);
//                        relationshipCount++;
//                    }
//                }
//            }
//            KList.add(relationshipCount / 2);  // 실제 관계의 개수
//        }
//    }
//}
package BOJ.겨울방학10;

import java.io.*;
import java.util.*;

public class 소셜네트워크_3098 {

    static int N;
    static int M;
    static int K;
    static ArrayList<Integer> KList = new ArrayList<>();
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    static ArrayList<HashSet<Integer>> updateList = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new HashSet<>());
            updateList.add(new HashSet<>());
        }
        // 인접 리스트 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            list.get(one).add(two);
            list.get(two).add(one);
            updateList.get(one).add(two);
            updateList.get(two).add(one);
        }
        bfs();
        System.out.println(K-1);
        for (Integer i : KList) {
            System.out.println(i);
        }
    }

    public static void bfs() {
        K = 0;
        // 아래 for문을 몇번 돌았는지 => 모든 사람이 서로 친구가 되는데 며칠이 걸리는지 (K)
        while (true) {

            // 관계 추가가 완료되었는지 체크
            int isEnd = 0;
            for (int i = 1; i <= N; i++) {
                if (list.get(i).size() == (N - 1)) {
                    isEnd++;
                }
            }
            if (isEnd == N) return;

            // 최신화
            for (int i = 1; i <= N; i++) {
                list.set(i, new HashSet<>(updateList.get(i)));
            }
            K++;  // 하루가 지났음을 표시
            int relationshipCount = 0;
            for (int i = 1; i <= N; i++) {
                for (int next : list.get(i)) {
                    for (int check : list.get(next)) {
                        // check가 list.get(i)에 없다면 추가, 있으면 넘어가기
                        if (updateList.get(i).contains(check) || check == i) continue;
                        updateList.get(i).add(check);
                        relationshipCount++;
                    }
                }
            }
            if (relationshipCount != 0) {
                KList.add(relationshipCount / 2);  // 실제 관계의 개수
            }
        }
    }
}
