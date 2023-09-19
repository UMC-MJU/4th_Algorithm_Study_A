import java.util.Scanner;

public class jewelBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int child =sc.nextInt();
        int color = sc.nextInt();

        int jewelBox[] = new int [color];

        for(int i=0; i<color; i++){
            jewelBox[i] = sc.nextInt();
        }
        int first = 1;
        int last = jewelBox[color -1];

        int person =0;
        int answer =0;
        while(first <= last){
            int middle = (first+last)/2;
            for(int j= color-1; j>=0; j--){

                if(jewelBox[j] % middle ==0)
                    person += jewelBox[j] / middle;
                else
                    person += (jewelBox[j]% middle) +1;
            }

            if(person <= child ) {//한사람당 보석을 많이 준 경우
                answer = middle;
                last =middle-1;
            }else{//한 사람당 보석을 적게 준 경우
                first = middle+1;
            }
        }
        System.out.println(answer);

    }
}
