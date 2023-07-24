package DP;

import java.util.Scanner;

//주어진 원소에 따라서 숫자를 순서에 상관있게 나열하는 알고리즘 ( 순열 )
public class BK_6603 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt(); //로또 번호를 입력 받을 개수
            if (k == 0) { //0을 입력 받으면 종료
                break;
            }

            int[] numbers = new int[k]; //로또 번호로 입력받은 개수 만큼 배열을 만들어 주기
            for (int i = 0; i < k; i++) {
                numbers[i] = scanner.nextInt();// 배열에 값을 넣기
            }

            boolean[] visited = new boolean[k];
            combination(numbers, visited, 0, 6);
            System.out.println();
        }

        scanner.close();
    }

    private static void combination(int[] numbers, boolean[] visited, int start, int select) {
        //주어진 숫자 배열 , 전에 구했던 순열인지 체크하는 배열 , 배열에서 시작하는 포인트를 나타내는 변수 , 6개의 숫자를 고르라고 했으니까
//        System.out.println("combination("+" number[] ,"+" visited[] ,"+(start)+" , " + (select)+") 재귀 깊게 들어가기");
        if (select == 0) {
            printCombination(numbers, visited);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            visited[i] = true;
            combination(numbers, visited, i + 1, select - 1);
            visited[i] = false;
        }
    }

    private static void printCombination(int[] numbers, boolean[] visited) {
//        System.out.println("printCombination 메서드 작동");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
//                System.out.println("numbers["+i+"]의 값은 "+numbers[i] + " ");
                sb.append(numbers[i]).append(" ");
            }
        }
        System.out.println(sb);
//        System.out.println("printCombination 메서드 종료");
    }
}
