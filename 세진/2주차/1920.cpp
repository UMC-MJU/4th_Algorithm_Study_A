#include "bits/stdc++.h"
using namespace std;
int n, m;
int a[100005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a+n); //이분탐색을 위한 오름차순 정렬
    cin >> m;
    while (m--) {
        int num;
        cin >> num;
        auto it = binary_search(a, a+n, num); //이분탐색 라이브러리 사용
        if(it){
            cout << "1" << "\n";
        }else{
            cout << "0" << "\n";
        }
    }
}