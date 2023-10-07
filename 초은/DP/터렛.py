# https://www.acmicpc.net/problem/1002
import sys, math

input = sys.stdin.readline

N = int(input())

for _ in range(N):
    data = list(map(int, input().split()))
    distance = math.sqrt(math.pow(data[0] - data[3], 2) + math.pow(data[1] - data[4], 2))
    if distance == 0:
        if data[4] == data[5]:
            print(-1)
        else:
            print(0)
    else:
        if distance == data[2] + data[5] or distance == abs(data[2] - data[5]):
            print(1)
        elif abs(data[2] - data[5]) < distance < (data[2] + data[5]):
            print(2)
        else:
            print(0)
