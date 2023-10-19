import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class strangeAlchol {
        static int kettle, person;
        static long[] drink;
        static void input() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            kettle = Integer.parseInt(st.nextToken()); // 주전자 개수
            person = Integer.parseInt(st.nextToken()); // 친구들의 수

            drink = new long[kettle];//친구들이 마실 용량
            for(int i = 0; i < kettle; i++) {
                st = new StringTokenizer(br.readLine());

                drink[i] = Long.parseLong(st.nextToken());
            }
        }
        /*--------input 메서드는 위에 ---------*/

        public static void main(String[] args) throws Exception {
            input();//입력 받을 값 받기
            pro();
        }
        /*--------pro 메서드는 아래에 ---------*/

        static void pro() {
            long L = 0, R = Integer.MAX_VALUE, ans = 0;//양 사이드 값을 넣을 변수
            while(L <= R) {//이분 탐색 시작
                long mid = (L + R) / 2;
                if(isValid(mid)) { //최대 용량을 찾으므로 조건 성립시 L을 증가
                    L = mid + 1;
                    ans = mid;
                } else {
                    R = mid - 1;
                }
            }

            System.out.println(ans);
        }
        static boolean isValid(long ml) {
            long cnt = 0;
            for(long d : drink) {
                cnt += (d / ml);
            }

            return cnt >= person;//사람의 인원수 만큼 적절하게 나누어 줄 수 있다면 true이겠지만 , 안된다면 false를 반환한다.
        }
    }
