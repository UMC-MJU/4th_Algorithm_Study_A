#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
ll n, m;
ll trees[1000005];
ll d[1000005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> trees[i];
    }
    sort(trees, trees + n, greater()); //나무의 높이를 내림차순 정렬
    d[0] = 0;
    for (int i = 1; i < n; i++) {
        d[i] = d[i - 1] + i * (trees[i - 1] - trees[i]); //d[i]는 i번째 나무까지의 자른 나무 길이 / 가장 높은 나무부터 절단기의 최댓값으로 지정하면서 내려감
        if(d[i] >= m){ //만약 d[i]가 m보다 크거나 같다면 이 i가 임계점이므로
            cout << trees[i] + (d[i] - m) / i; // i의 나무 길이 + 자른 나무 길이의 합을 d[i]가 m을 초과한 만큼 지나온 나무 갯수로 나누면 절단기의 최댓값
            return 0;
        }
    }
    for (int i = 1; i <= trees[n-1]; i++) { //위의 for문을 통과했다면 모든 나무를 지나도 최댓값을 찾지 못했다는 것
        if(d[n-1] + n*(trees[n-1] - (trees[n-1] - i)) >= m){ //가장 높이가 낮은 나무에서부터 1씩 빼가면서 최댓값 탐색
            cout << trees[n-1] - i;
            return 0;
        }
    }
}