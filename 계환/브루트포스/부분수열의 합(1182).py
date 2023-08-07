# 부분수열의 합 https://www.acmicpc.net/problem/1182

import sys
from itertools import combinations
input = sys.stdin.readline

# N = 정수의 개수; S = 타겟 정수
N, S = map(int, input().split())
# N개의 정수로 이루어진 수열
array = list(map(int, input().split()))

count = 0
for i in range(1, N+1):  # N의 최소값은 1이기 때문에 1부터 시작
    comb = combinations(array, i)

    for j in comb:
        if sum(j) == S:
            count += 1

print(count)