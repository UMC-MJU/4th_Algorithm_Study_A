# https://www.acmicpc.net/problem/10819

from itertools import permutations
import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

# 가능한 순열들을 튜플로 생성
per = permutations(a)
ans = 0

# 순열마다 차이를 더해, ans 보다 크면 ans에 저장
for i in per:
    s = 0
    for j in range(len(i) - 1):
        s += abs(i[j] - i[j + 1])
    if s > ans:
        ans = s

print(ans)
