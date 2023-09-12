#include "bits/stdc++.h"
using namespace std;
/**
 * 이게 구현문제인가? 유형을 잘 모르겠다,,
 * stack으로 들어오는 즉시 판단하며 풀어갔다.
 */
string s;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> s;
    if(s.size() % 2 != 0) { // stack 사이즈가 홀수이면 비정상적이므로 0출력 후 종료
        cout << 0;
        return 0;
    }
    stack<int> st;
    int res = 0;
    int cnt = 1; //콤보 쌓기
    bool cal = true; //콤보 쌓은거 계산 여부
    for (auto i: s) {
        if(i == '(' || i == '[') {
            cal = true;
            if(i == '(') cnt *= 2; //콤보 쌓는중
            if(i == '[') cnt *= 3; // 콤보 쌓는중 2
            st.push(i);
            continue;
        }
        if(i == ')') { // 얘 만났을 때 stack 탑이 ( 이게 아니면 종료
            if(st.empty() || st.top() != '(') {
                cout << 0;
                return 0;
            }
            if(cal) { //콤보 쌓아논거 cal true면 res 변수에 더해주면서 cal false 변경
                res += cnt;
                cal = false;
            }
            if(!st.empty()) st.pop();
            cnt /= 2;
        }
        if (i == ']') { //만약 cal이 false면 닫는 부호가 연속으로 나오는 것이므로 res 계산 안해줌
            if(st.empty() || st.top() != '[') {
                cout << 0;
                return 0;
            }
            if(cal) {
                res += cnt;
                cal = false;
            }
            if(!st.empty()) st.pop();
            cnt /= 3;
        }
    }
    cout << res;
}