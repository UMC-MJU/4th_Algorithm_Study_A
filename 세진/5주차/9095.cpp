#include "bits/stdc++.h"
using namespace std;
/**
 * 규칙 찾으면 쉽게 풇 수 있는 문제
 * DP 점화식을 찾아 풀었다.
 */
int t;
int d[13];
vector<int> V;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    int m = 0;
    for (int i = 0; i < t; i++) {
        int num;
        cin >> num;
        V.push_back(num);
        m = max(m, num);
    }
    d[1] = 1; d[2] = 2; d[3] = 4; //dp 초기값을 이렇게 설정
    for (int i = 4; i <= m; i++) {
        d[i] = d[i-1] + d[i-2] + d[i-3]; //후 규칙을 찾아 점화식 완성
    }
    for (auto i: V) {
        cout << d[i] << '\n';
    }
}