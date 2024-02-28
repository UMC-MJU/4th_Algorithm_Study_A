package practice;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class serialNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        String[] arr = new String[number];

        for(int i=0; i<number; i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String one, String two) {
                if(one.length() == two.length()){
                    int oneSum = 0;
                    int twoSum = 0;
                    for(int i=0; i<one.length(); i++){
                        if(one.charAt(i)>='0' && one.charAt(i)<='9')
                            oneSum += Integer.parseInt(String.valueOf(one.charAt(i)));
                    }
                    for(int i=0; i<two.length(); i++){
                        if(two.charAt(i)>='0' && two.charAt(i)<='9')
                            twoSum += Integer.parseInt(String.valueOf(two.charAt(i)));
                    }
                    if (oneSum == twoSum)
                        return one.compareTo(two);
                    else
                        return oneSum - twoSum;
                }else{
                    return one.length() - two.length();
                }
            }
        });
    }


}