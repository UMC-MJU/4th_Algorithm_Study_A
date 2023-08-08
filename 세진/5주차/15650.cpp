#include "bits/stdc++.h"
using namespace std;
/**
 * 조합을 backtracking으로 풀어보았다.
 * 순열과 달리 isUsed 배열이 필요 없었다.
 * 아직 재귀가 익숙하지 않지만 backtracking을 공부하면서 익숙해져 봐야곘다.
 */
int n, m;
int arr[10];
void func(int k, int idx){
    if(k == m){
        for (int i = 0; i < m; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for (int i = idx; i <= n; i++) {
        arr[k] = i;
        func(k + 1, i + 1);
    }
}
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(0, 1);
}