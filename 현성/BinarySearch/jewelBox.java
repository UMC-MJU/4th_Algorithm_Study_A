import java.util.Scanner;

public class jewelBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int N =sc.nextInt();
        int M = sc.nextInt();
        int sum =0;
        for(int i=0; i<M; i++){
            sum += sc.nextInt();
        }
        int answer=0;
        if(sum % N >0){
            answer+=(sum/N)+1;
        }else
            answer+= (sum/N);
        System.out.println(answer);
    }
}
