import java.util.Scanner;

public class turret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();
        while (Test-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            System.out.println(radius(x1, y1, r1, x2, y2, r2));
        }
    }
    public static int radius(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        // 중점간 거리 distance의 제곱 , pow( radi , n) 메서드 --> radi 반지름 의 n제곱

        // 두 원의 접점이 무한대인 경우
        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        // 두 원 사이의 접점이 한개도 없을때
        else if(distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }
        // 두 원 사이의 접점이 하나도 없는데 이 경우는 작은 원이 큰 원 안쪽에 있을때
        else if(distance_pow < Math.pow(r1-r2, 2)) {//여기서 Math.pow()인수에다가 r2-r1을 하나 r1-r2를 하나 제곱으로 음수가 나올수 없기 때문에 상관없다.
            return 0;
        }
        //큰 원과 작은 원이 내접 할 경우
        else if(distance_pow == Math.pow(r1-r2, 2)) {//여기서 Math.pow()인수에다가 r2-r1을 하나 r1-r2를 하나 제곱으로 음수가 나올수 없기 때문에 상관없다.
            return 1;
        }
        //큰 원과 작은 원이 외접 할 경우
        else if(distance_pow == Math.pow(r1 + r2, 2)) {
            return 1;
        }
            return 2;
    }
}
