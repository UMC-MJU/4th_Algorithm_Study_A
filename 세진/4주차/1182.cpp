#include "bits/stdc++.h"
using namespace std;
/**
 * 백트래킹 문제
 * 재귀를 이용해서 백트래킹을 구현했다
 */
int n, s;
int arr[30];
int cnt = 0;

void func(int cur, int tot){
    if (cur == n) {
        if(tot == s) cnt++;
        return;
    }
    func(cur + 1, tot); // 원소를 포함 안했을 때
    func(cur + 1, tot + arr[cur]); // 원소를 포함할 때
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> s;

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    func(0, 0);
    if(s == 0) cnt--;
    cout << cnt;
}