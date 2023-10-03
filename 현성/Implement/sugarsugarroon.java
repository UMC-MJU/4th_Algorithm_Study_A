import java.util.*;
public class sugarsugarroon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bag = sc.nextInt();
        int result = 0;

        if(bag ==4 || bag ==7) {//정확하게 N킬로그램으로 만둘 수 없는 경우 -1
            result = -1;
        }
        else if(bag % 5 == 1 ) {//정확하게 무게를 나눠야 한다는 조건때문에 5킬로 봉지로 개수를 나누어 담았으나 1킬로때매 안되는경우 6킬로가 되니 3킬로 봉지로 2개 나누어 담습니다.
            result = (bag/5)-1 + 2;
        }
        else if(bag % 5 == 2 || bag % 5 == 4) {
            result = (bag/5) - 2 + 4;
        }
        else if(bag % 5 == 3) {
            result = (bag / 5) + 1;
        }
        else if(bag % 5 == 4) {
            result = (bag / 5 ) - 1 + 3;
        }
        else if(bag % 5 == 0) {//5킬로 그램 봉지로 딱 맞춰서 나누어 담을수 있는경우
            result = bag / 5;
        }
        System.out.println(result);
    }
}
