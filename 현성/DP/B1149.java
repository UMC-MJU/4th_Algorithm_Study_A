package algorithm;

import java.util.*;

public class B1149{
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][]Paint;
    static int[][]home;

    static int draw(int number , int color){
        //최소비용을 계산하기 위한 조건
        if(home[number][color] == 0){
            if(color == Red){
                home[number][color]=Math.min(//만약 2번째 집이라고 한다면 1번째 집은 무조건 같은 색깔이 되면 안되기에
                        draw(number-1,Green)
                        ,draw(number-1,Blue)
                )
                        +Paint[number][Red];
            }else if(color == Green){
                home[number][color]=Math.min(
                        draw(number-1,Red)
                        ,draw(number-1,Blue)
                )
                        +Paint[number][Green];
            }else{
                home[number][color]=Math.min(
                        draw(number-1,Red)
                        ,draw(number-1,Green)
                )
                        +Paint[number][Blue];
            }
        }

        return home[number][color];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        Paint = new int[number][3];
        home = new int[number][3];
        //집마다 페인트 색상 칠할때 발생하는 비용을 paint 2차 행렬에 담기
        for(int i=0; i<number; i++){
            Paint[i][Red] = sc.nextInt();
            Paint[i][Green] = sc.nextInt();
            Paint[i][Blue] = sc.nextInt();
        }
        //각 생각마다 비용을 첫벗째 값으로 초기화 하여 이따 재귀에서 종료조건(0이 아니면 종료)을 따지기 위해서
        home[0][Red] = Paint[0][Red];
        home[0][Green] = Paint[0][Green];
        home[0][Blue] = Paint[0][Blue];

        //Math클래스에 min메서드는 2개씩만 비교 가능
        System.out.println(Math.min(
                draw(number-1,Red)
                ,Math.min(draw(number-1,Green)
                        ,draw(number-1,Blue)
        )));
    }


}