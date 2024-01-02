package practice;

import java.io.*;

public class RoomNumber {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int arr[] = new int[10];//0부터 9까지 담은 배열

        for(int n=0; n<str.length(); n++){
            int numericValue = Character.getNumericValue(str.charAt(n));//getNumbericValue메서드는 char 문자로 된 숫자를 int 숫자로 변경

            if(numericValue==6) arr[9]++;

            else arr[numericValue]++;
        }
        int max = 0;

        for(int i=0; i<9; i++){ //인덱스 9를 빼는 이유는 위 for문에서 6이 나온경우 인덱스 9를 추가하였기 때문에 따로 9를 계산 하는 로직이 필요
            max = Math.max(max, arr[i]);
        }
        int nine = arr[9]/2; //6과 9 숫자는 뒤집어서 사용할 수 있다고 하였기에 6699와 같은 경우는 4가 아닌 2가 출력되어야 한다.
        if( arr[9]%2 ==1) nine++; //66999와 같이 3세트가 필요한 경우 한 세트 더 더해주어야 합니다.
        max = Math.max(max, nine);//위에서 최대 세트와 다시 비교하여 최대 필요한 세트 수 출력하기
        System.out.println(max);


    }

}
