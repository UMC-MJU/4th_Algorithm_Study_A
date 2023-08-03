#include "bits/stdc++.h"
using namespace std;
/**
 * 순열을 backtracking으로 풀어봤다.
 * 확실히 prev_permutation으로 푸는게 간단하긴 하지만
 * 실력 향상을 위해 backtracking으로 풀어보았다.
 */
int n, m;
int arr[10];
bool isUsed[10];
void func(int k){
    if(k == m) {
        for (int i = 0; i < m; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (!isUsed[i]) {
            arr[k] = i;
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;
        }
    }
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    func(0);
}