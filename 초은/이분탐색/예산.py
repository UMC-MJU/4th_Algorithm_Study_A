# https://www.acmicpc.net/problem/2512

import sys

input = sys.stdin.readline
N = int(input())    # 지방 수
request = list(map(int, input().strip().split()))   # 지방 별로 요청한 예산 배열
budget = int(input())       # 줄 수 있는 예산 총량
start, end = 0, max(request)

if sum(request) <= budget:  # 모든 요청에 배정될 수 있는 경우
    print(max(request))
    exit()
while start <= end:         # 예산 총량이 모자른 경우 이분탐색 시작
    mid = (start + end) // 2    # 중간값
    total = 0                   # 배당한 예산 양 초기화
    for i in request:
        if i > mid:     # 요청한 양이 중간값보다 클 때 중간값 주기
            total += mid
            continue
        total += i      # 요청한 양이 중간값보다 작거나 값으면 요청한 양 그대로 주기
    if total <= budget: # 배당한 예산 양이 줄 수 있는 양보다 작거나 같을 때
        start = mid + 1
        continue
    end = mid - 1       # 배당한 예산 양이 줄 수 있는 양보다 클 때 (불가능한 상태)
print(end)