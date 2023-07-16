package DFS_BFS;

import java.util.Scanner;
// https://gomgomkim.tistory.com/19
public class Daikstra {
    static int V;
    static int E;
    static int K;
    static int graph[][];
    static void daik (int num){
        int distance[] = new int[V];
        boolean check[] = new boolean[V];

        for(int a=0; a<V; a++){// 최대 가중치값으로 초기화를 해놓고 간선으로 연결되어 있다면 아래 로직에서 최소 값으로 갱신될테고 최소값으로 갱신이 안된 노드는 연결이 안되어있다는 뜻
            distance[a] = Integer.MAX_VALUE;
        }
        //시작노드인 자기 자신은 가중치가 0
        distance[num] = 0;
        check[num] = true;
        // 결과값 출력해보기
        System.out.print(">>>>>>>");
        for(int i=0; i<V; ++i){
            if(distance[i] == 2147483647) System.out.print("∞ ");
            else System.out.print(distance[i]+" ");
        }
        System.out.println();
        for(int j=0; j<V; j++){
            if(graph[num][j] != Integer.MAX_VALUE && !check[j]) distance[j] = graph[num][j];
        }
        // 결과값 출력해보기
        System.out.print(">>>>>>>");
        for(int i=0; i<V; ++i){
            if(distance[i] == 2147483647) System.out.print("∞ ");
            else System.out.print(distance[i]+" ");
        }
        System.out.println();
        for(int a=0; a<V-1; ++a){
            // 원래는 모든 노드가 true될때까지 인데
            // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            // 원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            // 노드 최소값 찾기
            for(int i=0; i<V; ++i){
                if(!check[i]){
                    if(distance[i] < min){
                        min = distance[i];
                        min_index = i;
                    }
                }
            }

            // 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인한다.
            check[min_index] = true;
            for(int i=0; i<V; ++i){
                if(!check[i] && graph[min_index][i] != Integer.MAX_VALUE){
                    if(distance[min_index] + graph[min_index][i] < distance[i]){
                        distance[i] = distance[min_index] + graph[min_index][i];
                    }
                }
            }

            // 결과값 출력
            System.out.print(">>>>>>>");
            for(int i=0; i<V; ++i){
                if(distance[i] == 2147483647) System.out.print("∞ ");
                else System.out.print(distance[i]+" ");
            }
            System.out.println("");
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input 입력받기
        V = sc.nextInt(); //정점의 개수
        E = sc.nextInt(); //간선의 개수
        K = sc.nextInt(); //시작 정점의 번호

        graph = new int[V][V];       //가중치를 저장할 그래프
        for(int i=0; i<V; i++){
            for(int j=0; j<V;j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int input =0; input < E; input++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            int weight = sc.nextInt();
            graph[row][col] = weight;
            graph[col][row] = weight;
        }
        daik(K);


    }
}
