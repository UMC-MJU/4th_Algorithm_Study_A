import java.io.BufferedReader;
import java.io.InputStreamReader; 
public class Main {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         board = new char[N][N];
         for (int i = 0; i < N; i++) {            
		String s = br.readLine();
                      for (int j = 0; j < N; j++) {
                	board[i][j] = s.charAt(j);            
			}        
	}


}
