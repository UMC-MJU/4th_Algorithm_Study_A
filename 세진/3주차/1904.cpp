#include "bits/stdc++.h"
using namespace std;
int n;
int d[1000005]; //DP 테이블
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    /**
     * N이 주어졌을 때 규칙은
     * nC0 + n-1C1 + n-2C2 ... (n/2+1)C(n/2)
     */
    d[1] = 1; d[2] = 2;
    for (int i = 3; i <= n; i++) {
        d[i] = (d[i - 1] + d[i - 2]) % 15746; //규칙을 찾아 점화식을 완성했다
    }
    cout << d[n];
}
