#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
ll n, m;
ll budget[10005];
ll d[10005];
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> budget[i];
    cin >> m;
    sort(budget, budget + n); //예산 오름차순 정렬
    d[0] = 0;
    for(int i = 1; i <= n; i++) {
        d[i] = d[i - 1] + budget[i - 1]; //예산을 저장하면서 더해가는 코드
    }
    for (int i = 1; i <= n; i++) {
        if(d[i] + (n - i) * budget[i - 1] > m) { //만약 예산의 합이 m을 조과하는 경우 이 budget[i-1]를 임계점으로 지정
            cout << (m - d[i - 1]) / (n - i + 1); //총 예산에서 budget[i-2] 까지의 합을 뺀 후 남은 예산을 남은 지방에게 똑같이 부여
            return 0;
        }
    }
    cout << budget[n - 1]; //만약 위의 for문을 통과했다면 예산이 넘쳐흐르는 것이므로 최댓값은 budget[n-1]
}