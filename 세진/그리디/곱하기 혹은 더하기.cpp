#include "bits/stdc++.h"
using namespace std;
string s;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> s;
    int result = s[0] - '0';
    for (int i = 1; i < s.length(); i++) {
        if(result == 0) {
            result += (s[i] - '0');
            continue;
        }
        if(s[i] == 0) continue;
        result *= (s[i] - '0');
    }
    cout << result;
}