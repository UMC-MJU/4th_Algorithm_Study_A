package DP;

import java.util.Scanner;

public class BK_1182번 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        //-7 -3 -2 5 8 입력 된 상태
        findSubsetSum(numbers, 0, 0, S);
        // 합이 0인 경우 빈 부분 수열도 하나로 카운트되므로, 결과에서 제외합니다.
        if (S == 0) {
            count--;
        }
        System.out.println(count);
        scanner.close();
    }
    private static void findSubsetSum(int[] numbers, int index, int sum, int target) {
        System.out.println(" index의 값은 " +index +" sum 의 값은 " +sum +" target의 값은 " +target);
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            System.out.println("재귀 함수 종료 ");
            return;
        }
        System.out.println("원소 포함 메서드 들어가기전 index의 값은 " +index +" sum 의 값은 " +sum +" target의 값은 " +target);
        // 현재 인덱스의 원소를 포함하는 경우
        findSubsetSum(numbers, index + 1, sum + numbers[index], target);
        System.out.println("원소 포함 하는 메서드 종료 ");
        System.out.println("원소 포함 하지않는 메서드 들어가기전 index의 값은 " +index +" sum 의 값은 " +sum +" target의 값은 " +target);
        // 현재 인덱스의 원소를 포함하지 않는 경우
        findSubsetSum(numbers, index + 1, sum, target);
        System.out.println("원소 포함하지 않는 메서드 종료 ");
    }

}
