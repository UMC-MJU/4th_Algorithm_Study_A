# 두 수의 합 https://www.acmicpc.net/problem/3273

import sys
input = sys.stdin.readline

# 수열의 크기
n = int(input())
list = list(map(int, input().split()))
x = int(input())

# 해시 사용
dict = {}
count = 0

for i in list:
    if i in dict:
        count += 1
    dict[x - i] = i
print(count)

