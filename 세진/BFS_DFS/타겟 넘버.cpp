//Programmers Lv. 2 https://school.programmers.co.kr/learn/courses/30/lessons/43165
#include <string>
#include <vector>
#include <stack>
using namespace std;
int dn[2] = {1, -1};
int solution(vector<int> numbers, int target) {
    stack<pair<int, int>> S;
    S.push({1, numbers[0]});
    S.push({1, -numbers[0]});
    int ans = 0;
    while(!S.empty()){
        pair<int, int> cur = S.top();
        S.pop();
        if(cur.first == numbers.size()) {
            if(cur.second == target) ans++;
            continue;
        }
        for(int i = 0; i < 2; i++){
            int next = cur.second + dn[i] * numbers[cur.first];
            S.push({cur.first + 1, next});
        }
    }
    return ans;
}