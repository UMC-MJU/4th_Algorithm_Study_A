#include "bits/stdc++.h"
using namespace std;
/**
 * BFS 문제
 * dis라는 2차원 배열에 거리를 저장해가면서 풀 수 있었다.
 */
#define X first
#define Y second
int m, n;
int board[1005][1005];
int dis[1005][1005]; // 거리 저장 배열
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;

    for (int i = 1; i <= n; i++)
        fill(dis[i], dis[i] + m + 1, -1);

    queue<pair<int, int>> q;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int num;
            cin >> num;
            board[i][j] = num;
            if(num == 1) {
                q.push({j, i});
                dis[i][j] = 0; // board[i][j]가 토마토일 때 dis[i][j] = 0으로 설정
            }
        }
    }

    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for (int nxt = 0; nxt < 4; nxt++) {
            int nx = cur.X + dx[nxt];
            int ny = cur.Y + dy[nxt];
            if(nx < 1 || nx > m || ny < 1 || ny > n) continue;
            if(dis[ny][nx] >= 0 || board[ny][nx] == -1) continue; //dis배열이 -1이 아니면 방문한 것 + board배열이 -1 이면 공간이므로 Pass
            dis[ny][nx] = dis[cur.Y][cur.X] + 1; // dis 배열의 nxt 좌표에 1을 더해 거리 설정
            q.push({nx, ny});
        }
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if (dis[i][j] == -1 && board[i][j] == 0) {
                cout << -1; // dis 배열이 -1 이면서 board배열이 0이면 안익은 토마토가 존재하므로 -1 출력
                return 0;
            }
            res = max(res, dis[i][j]); //dis 배열을 탐색하면서 최댓값 탐색
        }
    }
    cout << res;
}