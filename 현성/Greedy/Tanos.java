import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tanos{
    private void solution() throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); //입력값 받기
        char[] arr = new char[s.length()]; //입력 받은길이 만큼 char형태의 배열로 만들어준다.

        int zero = 0;
        int one = 0;

        for (int i = 0; i < arr.length; i++) { //입력 받은 만큼 반복
            arr[i] = s.charAt(i); //입력받은 문자열을 하나씩 꺼내서
            if (arr[i] == '0') zero++; //문자 "0"이라면 숫자 1을 추가해주기
            else one++;//문자 "1"이라면 숫자 1을 추가해주기
        }
        zero/=2; //타노스 효과로 절반씩 잘라서 zero 변수에 다시 담아주기
        one/=2;

        for (int i = 0; i < s.length() ; i++) {
            if (arr[i] == '1'&& one!=0) {//앤드 조건으로 0이 아니라면을 붙인 이유는 0000에서 문자 1이 없다면 통과할 수 있도록
                one--;
                arr[i] = 0;
            }
        }
        System.out.println();
        for (int i = s.length()-1; i >= 0 ; i--) {
            //인덱스를 뒤에서부터 도는 이유는 문제에서 사전순으로 할때
            // 가장 빠른 것을 출력하기에 '0'이 뒤에 올경우 문제에서 말하는 가장 느린경우가 될수 있따.
            if (arr[i] == '0'&& zero!=0) {
                zero--;
                arr[i] = 0;//char배열에다가 0을 넣을경우는 유니코드 /u0000(널)값이 들어가게 됩니다. '0' 과 0의 차이 입니다.
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            System.out.println( i+"번째 "+arr[i] );
            if (arr[i] != 0) {
                System.out.println( i+"번째 추가 " );
                answer.append(arr[i]);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Tanos().solution(); //항상 메인 메서드에서 시작했는데 이런 방식으로도 시작하는것을 깨닫고 신기해서 따라 해보았습니다.
    }
}