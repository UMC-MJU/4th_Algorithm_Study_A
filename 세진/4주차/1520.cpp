#include "bits/stdc++.h"
using namespace std;
/**
 * 시간초과로 인한 실패
 * 왜 DP를 써야만 하는지 궁금하다.
 */
int m, n;
int board[505][505];
int dx[3] = {1, 0, -1};
int dy[3] = {0, 1, 0};
int cnt;
void func(int x, int y){
    if(x == n - 1 && y == m - 1) {
        cnt++;
        return;
    }
    for (int nxt = 0; nxt < 3; nxt++) {
        int nx = x + dx[nxt];
        int ny = y + dy[nxt];
        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if(board[y][x] <= board[ny][nx]) continue;
        func(nx, ny);
    }
}
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++)
            cin >> board[i][j];
    }
    func(0, 0);
    cout << cnt;
}
