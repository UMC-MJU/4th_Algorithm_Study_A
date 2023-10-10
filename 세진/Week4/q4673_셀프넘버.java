package Week4;

import java.util.TreeSet;

class q4673_셀프넘버 {
    public static void main(String[] args) {
        TreeSet<Integer> list = new TreeSet<>(); // 중복을 허용하지 않는 정렬된 Set
        for (int i = 1; i < 10000; i++) {
            String numberStr = Integer.toString(i); // 정수를 String으로 변환
            int num = 0;
            for (int j = 0; j < numberStr.length(); j++) {
                int digit = Character.getNumericValue(numberStr.charAt(j)); // char를 Integer로 변환
                num += digit;
            }
            if (i + num <= 10000) {
                list.add(i + num); // 숫자와 각 자리의 합을 더한 후 TreeSet에 추가
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if(!list.contains(i)) System.out.println(i); //list에 없는 원소들을 모두 출력
        }
    }
}