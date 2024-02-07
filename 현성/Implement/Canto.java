import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        FileInputStream inputFile = new FileInputStream("src/data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFile));
        String str;
        while((str = br.readLine()) != null){
            int number = Integer.parseInt(str);
            int len = (int) Math.pow(3, number);

            sb = new StringBuilder();
            for(int i=0;i < len; i++){
                sb.append("-");
            }
            canto(0, len);
            System.out.println(sb);
        }
    }
    private static void canto(int start , int size){

        if(size ==1){
            return ;
        }
        int newSize = size / 3;
        for(int i = start + newSize; i < start + 2* newSize; i++){
            sb.setCharAt(i , ' ');
        }

        canto(start , newSize);
        canto(start + 2* newSize , newSize);
    }

}
