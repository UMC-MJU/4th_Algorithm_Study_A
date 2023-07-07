#include "bits/stdc++.h"
using namespace std;
int n;
vector<int> arr;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        arr.push_back(num);
    }
    sort(arr.begin(), arr.end());
    int result = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
        count += 1;
        if(count >= arr[i]) {
            result++;
            count = 0;
        }
    }
    cout << result;
}