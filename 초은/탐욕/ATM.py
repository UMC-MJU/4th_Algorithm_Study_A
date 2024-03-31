# https://www.acmicpc.net/problem/11399

import sys
T = int(input())
data = list(map(int, sys.stdin.readline().split()))

data.sort()
total = 0
for i in range(T):
    total += sum(data[:i + 1])
print(total)
