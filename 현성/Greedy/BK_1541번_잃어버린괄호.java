import java.util.*;

public class BK_1541번_잃어버린괄호 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String mathExpression = sc.next();

        //
        String[] strArr =mathExpression.split("-");
        /*
        새롭게 안 사실 정규표현식에서 "+" , "."와 같은 기타 기호들은 이스케이프 문자를 사용해서 정규표현식을 활용하여준다 .

        +는 정규 표현식에서 "바로 앞의 패턴이 1회 이상 반복되는지"를 나타냅니다.

        예를 들어, a+는 "a가 1회 이상 반복되는 패턴"을 의미합니다.
        이런식으로 앞에 패턴이 1회 이상 반복되는 경우에 사용됩니다.  -는 정규 표현식에서 특별한 의미를 가지지 않습니다.
        즉, -는 일반 문자로서 그 자체로 매칭됩니다.  예를 들어, a-b는 "a, 그리고 - 그리고 b"라는 패턴을 나타냅니다.
        여기서 -는 특별한 의미를 갖지 않고 문자 그대로 해석됩니다.
        */
        int result =0;
        for(int i=0; i<strArr.length; i++){
            String plusArr[] = strArr[i].split("\\+");

            int sum =0;//-로 쪼개어진 수식들중에서 +를 기준으로 나눈 숫자들끼리 더해서 담을 변수
            for(String str : plusArr){
                sum += Integer.parseInt(str);
            }
            if(i==0){
                result = sum;
            }else{
                //i가 0이 아닌경우는 앞에서 -로 이미 나뉘어진경우를 거쳐서 오면 무조건 뺴기를 해야하니까
                //ex ) (40+10) - (10+20+30) - (1+2+3+4) 이런식으로 되기 때문에
                result -= sum;
            }
        }
        System.out.println(result);

    }
}