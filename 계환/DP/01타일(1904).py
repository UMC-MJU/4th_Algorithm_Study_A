# 01타일 https://www.acmicpc.net/problem/1904

import math  # 팩토리얼 메서드를 사용하기 위함
import sys

input = sys.stdin.readline

N = int(input())

answer = 0
div = N // 2

for i in range(div+1):
    answer += math.comb(N-i, i)

answer %= 15746
print(int(answer))
