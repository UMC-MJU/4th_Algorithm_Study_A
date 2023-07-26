#include "bits/stdc++.h"
using namespace std;
/**
 * 순열을 이용해 모든 번호를 출력하게 했다.
 */
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (1) {
        int k;
        cin >> k;
        if(k == 0) break;

        vector<int> v;

        for (int i = 0; i < k; i++) {
            int num;
            cin >> num;
            v.push_back(num);
        }

        vector<bool> temp(k);

        fill(temp.begin(), temp.begin() + 6, true);
        do { // 순열 돌리는 코드
            for (int i = 0; i < k; ++i) {
                if (temp[i]) {
                    cout << v[i] << " ";
                }
            }
            cout << "\n";
        } while (prev_permutation(temp.begin(), temp.end()));
        cout << "\n";
    }
}