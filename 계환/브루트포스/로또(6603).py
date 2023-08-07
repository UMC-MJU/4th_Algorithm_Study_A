# 로또 https://www.acmicpc.net/problem/6603

import sys
from itertools import combinations
input = sys.stdin.readline

while True:
    array = list(map(int, input().split()))

    k = array[0]
    if k == 0:
        break
    S = array[1:]

    for i in combinations(S, 6):
        print(*i)

    print()