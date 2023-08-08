#include "bits/stdc++.h"
using namespace std;
/**
 * 좀 더 연구해보겠읍니다..
 */
int N, M;
vector<int> numbers, seq;
void backtracking(int start, int depth) {
    if (depth == M) {
        for (int i = 0; i < M; i++) {
            cout << seq[i] << " ";
        }
        cout << "\n";
        return;
    }
    int prev = -1;
    for (int i = start; i < N; i++) {
        if (numbers[i] != prev) {
            prev = numbers[i];
            seq[depth] = numbers[i];
            backtracking(i + 1, depth + 1);
        }
    }
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    numbers.resize(N);
    seq.resize(M);
    for (int i = 0; i < N; i++) {
        cin >> numbers[i];
    }
    sort(numbers.begin(), numbers.end());
    backtracking(0, 0);
}