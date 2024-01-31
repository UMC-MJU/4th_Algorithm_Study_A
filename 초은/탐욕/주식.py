# https://www.acmicpc.net/problem/11501
import sys

T = int(input())
for _ in range(T):
    N = int(input())
    data = list(map(int, sys.stdin.readline().split()))
    present = 0

    while True:
        if len(data) <= 1:
            break
        max_index = data.index(max(data))
        if max_index == 0: # 이거 체크 안하면 시간초과
            if data == sorted(data, reverse=True):
                break
        present -= sum(data[:max_index], (-1) * max_index * data[max_index])
        data = data[max_index + 1:]
        
    print(present)
