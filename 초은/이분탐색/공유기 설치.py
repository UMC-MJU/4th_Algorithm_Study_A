# https://www.acmicpc.net/problem/2110

import math, sys
input = sys.stdin.readline

N, C = map(int, input().split())    # 집 개수, 공유기 개수
h = [int(input()) for i in range(N)]    # 집들의 좌표 받아서 오름차순 정렬
h.sort()

# 이분탐색을 집 사이의 거리로 한다
start, end = 1, h[N-1] - h[0]   # 집 사이의 최소 거리, 최대 거리
result = 0

if C == 2:  # 공유기가 2개라면 무조건 처음, 마지막 집 사이의 거리
    print(h[N-1] - h[0])
else:
    while(start < end):
        mid = (start + end)//2  # 이분탐색에 필요한 mid

        count = 1
        ts = h[0]   # 첫번째 집에는 공유기 무조건 설치

        for i in range(N):
            if h[i] - ts >= mid:    # mid보다 크면 공유기 설치
                count += 1
                ts = h[i]

        if count >= C:  # 설치한 공유기가 C보다 많거나 같을 때
            result = mid
            start = mid + 1
            continue
        end = mid   # C보다 적게 설치했을 때

    print(result)