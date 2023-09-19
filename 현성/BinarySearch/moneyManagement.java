import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class moneyManagement {
    static int withdrawMoney[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int day = Integer.parseInt(str[0]);//계획한 N일
        int withdraw = Integer.parseInt(str[1]); //계획한 인출 횟수
        withdrawMoney =  new int[day];

        int last = 0;
        int first = 0;
        int max = 0;
        int result = 0;
        for (int i = 0; i < day; i++) {
            withdrawMoney[i] = Integer.parseInt(br.readLine());
            last += withdrawMoney[i];
            max = Math.max(max, withdrawMoney[i]);

        }
        first = max;
        while (first <= last){
            int mid = (first + last)/2;
            //이진 탐색을 위한 평균 값 찾기
            if(withdraw >= binaryMoney(mid)){
                //계획 했던 인출 횟수 보다 작아야지만 if절이 가능
                result = mid;
                last = mid - 1;
            }else{
                first = mid+1;
            }
        }

        System.out.println(result);
    }

    static int binaryMoney(int tempMoney){
        int count = 1;
        int money = tempMoney;

        for(int num : withdrawMoney){
            money -= num;
            //withdrawMoney 배열에 각 날마다 쓸 돈을 적어놓았는데
            //비용이 적다면 마이너스가 나올것이고 그렇다면 if절이 발동한다
            if(money < 0){
                //리턴 값 count를 한개씩 올려주어서 나중에 main 함수에서
                //
                count++;
                money = tempMoney - num;
            }

        }
        return count;
    }
}