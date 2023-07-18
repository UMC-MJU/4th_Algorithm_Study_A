#include "bits/stdc++.h"
using namespace std;
int n, m, k, x; //n: 도시 개수, m: 도로 개수, k: 거리 정보, x: 출발 도시 번호
vector<int> adj[300005];
bool vis[300005];
int dis[300005];
/**
 * 다익스트라를 떠올리려 했다가 모든 거리가 1이기 때문에
 * BFS만 돌려도 최단거리 탐색 가능
 */
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m >> k >> x;
    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        adj[from].push_back(to);
    }
    queue<int> q;
    q.push(x);
    vis[x] = true;
    while (!q.empty()) { //BFS를 돌려 x로부터 거리를 dis에 저장해나가면서 탐색
        int cur = q.front();
        q.pop();
        for (int nxt: adj[cur]) {
            if(vis[nxt]) continue;
            dis[nxt] = dis[cur] + 1;
            q.push(nxt);
            vis[nxt] = true;
        }
    }
    vector<int> res;
    for (int i = 1; i <= n; i++) {
        if(i != x && dis[i] == k) { //최단 거리가 K 이면 저장
            res.push_back(i);
        }
    }
    if(res.empty()){ //없으면 -1
        cout << -1;
        return 0;
    }
    sort(res.begin(), res.end()); //저장값 정렬
    for (auto i: res) {
        cout << i << "\n";
    }
}