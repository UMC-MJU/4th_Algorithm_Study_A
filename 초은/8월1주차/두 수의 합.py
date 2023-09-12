# https://www.acmicpc.net/problem/3273

import sys
input = sys.stdin.readline

n = int(input())    # 수열의 크기
data = list(map(int, input().split()))
x = int(input())    # 찾고자 하는 합

data.sort()

count = 0
interval_sum = 0
start, end = 0, n - 1     # 포인터

# start를 차례대로 증가시키며 반복
while start <= end:

    if data[start] + data[end] < x:
        end -= 1
    elif data[start] + data[end] > x:
        start += 1
    else:
        count += 1
        start += 1
        end -= 1

print(count)