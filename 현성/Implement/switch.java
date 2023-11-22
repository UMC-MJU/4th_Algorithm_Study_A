import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;

    private static int switchNumber;        // 스위치 개수
    private static int[] switchStatus;      // 스위치
    private static int student;             // 학생 수
    private static int human ;              // 남학생인지 여학생인지
    private static int indexSwitch;         // 학생이 선택한 스위치 번호

    private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        switchNumber  = Integer.parseInt(br.readLine());            //스위치 개수 입력 받기
        StringTokenizer token = new StringTokenizer(br.readLine());

        switchStatus = new int[switchNumber+2];

        for(int i=1; i<=switchNumber; i++){
            switchStatus[i] = Integer.parseInt(token.nextToken());  // 각 스위치마다 칸에 0과 1을 넣어서 on off 표시하기
        }
        student = Integer.parseInt(br.readLine());                  //학생 수 입력받기
//        System.out.print("\n"+Arrays.toString(Arrays.copyOfRange(switchStatus,1,switchStatus.length))+"\n");
    }

    private static void selectSwitch() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        human = Integer.parseInt(st.nextToken());               //남학생 or 여학생
        indexSwitch = Integer.parseInt(st.nextToken());               //해당하는 전구 번호
    }
    private static void changeSwitch(){
        if(human ==1)
            man(indexSwitch);
        else if(human==2)
            woman(indexSwitch);
    }
    private static void man(int index){
        int jump = index;
        while(jump <= switchStatus.length){
            if(switchStatus[jump] == 0)
                switchStatus[jump] =1;
            else if (switchStatus[jump]==1)
                switchStatus[jump] =0;
            jump += index;
        }
//        System.out.println("man = "+Arrays.toString(Arrays.copyOfRange(switchStatus,1,switchStatus.length)));
    }
    private static void woman(int index){
        if(switchStatus[index] == 0)
            switchStatus[index] =1;
        else if (switchStatus[index]==1)
            switchStatus[index] =0;

        int side =1;
        while ((index - side)>0 && (index+ side)<switchStatus.length){
            int left = index - side;
            int right = index+ side;
            if(switchStatus[left] == switchStatus[right]){
                if(switchStatus[left]==0) {//left든 right든 어차피 같다면이라는 조건문으로 들어온경우니 아무거나 사용해도 가능
                    switchStatus[left]=1;
                    switchStatus[right]=1;
                }else if(switchStatus[right] ==1){
                    switchStatus[left]=0;
                    switchStatus[right]=0;
                }
                side++; //index 기준 양옆으로 퍼지면서 체크하기
            }else {
//                System.out.println("woman = "+Arrays.toString(Arrays.copyOfRange(switchStatus,1,switchStatus.length)));
                break;
            }
        }
    }
    private static void printResult(){
        for(int k=1 ; k<switchStatus.length; k++){
            System.out.print(switchStatus[k]+" ");
            if(k%20  == 0 )// 20개씩 끊어서 출력하라고 문제에서 조건을 제시했기 때문에
                System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for(int j=0; j<student; j++) {
            selectSwitch();
            changeSwitch();
        }
        printResult();
    }
}
