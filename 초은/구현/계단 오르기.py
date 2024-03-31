# https://www.acmicpc.net/problem/2579

from sys import stdin

N = int(input())
stairs = [int(stdin.readline()) for _ in range(N)]
count = sum(stairs)
tmp = len(stairs) - 2

while True:
    if tmp < 3:
        break

    minus_stair = min(stairs[tmp], stairs[tmp - 1], stairs[tmp - 2])

    if minus_stair == stairs[tmp]:
        tmp = tmp - 1
    elif minus_stair == stairs[tmp - 1]:
        tmp = tmp - 2
    else:
        tmp = tmp - 3

    count -= minus_stair
    # print(minus_stair)

print(count)



