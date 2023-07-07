#include "bits/stdc++.h"
using namespace std;
int n, k;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> k;
    int count = 0;
    while (n != 1) {
        if(n % k == 0) {
            n /= k;
            count++;
            continue;
        }
        n -= 1;
        count++;
    }
    cout << count;
}