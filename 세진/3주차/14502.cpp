#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int n, m; //n: 세로 크기, m: 가로 크기
int board[10][10];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
/**
 * 완전탐색 + BFS
 * 아이디어를 떠올리는 것이 쉽지 않았다.
 * 모든 벽을 세울 수 있는 경우의 수를 돌려서
 * 벽을 세운다 => 바이러스를 퍼트린다 => 만약 공간이 아무것도 없으면 방어 실패
 * 벽울 세운다 => 바이러스를 퍼트린다 => 모든 공간 탐색 후 최댓값 계산
 */
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    vector<pair<int, int>> space;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int type;
            cin >> type;
            board[i][j] = type;
            if(type == 0) space.push_back({j, i}); //공간 좌표 저장
        }
    }
    int res = 0;
    vector<bool> temp(space.size(), true);
    for (int i = 0; i < space.size() - 3; i++)
        temp[i] = false;
    do{ // Combination 으로 모든 경우의 수 탐색
        int temp_board[10][10];
        copy(&board[0][0], &board[0][0] + 100, &temp_board[0][0]);
        int temp_vis[10][10];
        for (int i = 0; i <= n; i++)
            fill(temp_vis[i], temp_vis[i] + m + 1, -1);
        vector<pair<int, int>> new_walls;
        for (int i = 0; i < space.size(); ++i) {
            if(temp[i])
                new_walls.push_back(space[i]); //Combination으로 찾은 벽 임시 저장
        }
        for (auto i: new_walls) {
            temp_board[i.Y][i.X] = 1; //벽 세우기
        }
        for (int i = 1; i <= n; i++) { //바이러스 퍼뜨리기
            for (int j = 1; j <= m; j++) {
                if(temp_vis[i][j] == 1 || temp_board[i][j] == 1 || temp_board[i][j] == 0) continue;
                queue<pair<int, int>> q;
                q.push({j, i});
                temp_vis[i][j] = 1;
                while (!q.empty()) {
                    pair<int, int> cur = q.front();
                    q.pop();
                    for (int nxt = 0; nxt < 4; nxt++) {
                        int nx = cur.X + dx[nxt];
                        int ny = cur.Y + dy[nxt];
                        if(nx < 1 || nx > m || ny < 1 || ny > n) continue;
                        if(temp_vis[ny][nx] == 1 || temp_board[ny][nx] == 1) continue;
                        q.push({nx, ny});
                        temp_vis[ny][nx] = 1;
                    }
                }
            }
        }
        int temp_space_size = 0;
        for (int i = 1; i <= n; i++) { //바이러스 퍼뜨린 후 공간이 있는지 탐색
            for (int j = 1; j <= m; j++) {
                if(temp_vis[i][j] == -1 && temp_board[i][j] == 0) temp_space_size++; //만약 공간이 있으면 ++
            }
        }
        if(temp_space_size == 0) continue;
        res = max(res, temp_space_size); //최댓값 탐색
    } while(next_permutation(temp.begin(), temp.end()));
    cout << res;
}