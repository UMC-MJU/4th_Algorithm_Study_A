# https://www.acmicpc.net/problem/3079

from sys import stdin

N, M = map(int, stdin.readline().split())
arr = [int(stdin.readline()) for _ in range(N)]

# 심사대에서 한명이 심사를 받는 최소 시간
short = min(arr)
# 심사대에서 M 명이 심사를 받는 최대 시간
long = max(arr) * M
time = long

while short <= long:
    total = 0
    mid = (short + long) // 2

    for i in range(N):
        total += mid // arr[i]

    # 모든 인원이 심사를 받음
    if total >= M:
        long = mid - 1
        time = min(mid, time)
    # 모든 인원이 심사를 받지 못함
    else:
        short = mid + 1

print(time)
