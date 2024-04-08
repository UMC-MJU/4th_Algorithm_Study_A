# https://www.acmicpc.net/problem/16928

import sys

# N, M 입력
N, M = map(int, sys.stdin.readline().strip().split())

# 사다리의 정보들
ladders = {}
for _ in range(N):
  x, y = map(int, sys.stdin.readline().strip().split())
  ladders[x] = y

# 뱀의 정보들
snakes = {}
for _ in range(M):
  x, y = map(int, sys.stdin.readline().strip().split())
  snakes[x] = y

