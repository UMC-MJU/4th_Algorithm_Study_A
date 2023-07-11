# https://www.acmicpc.net/problem/2805

import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split())    # 나무 수, 필요한 나무 길이
trees = list(map(int, input().strip().split())) # 존재하는 나무 길이 배열
start, end = 0, max(trees)  # 이분탐색 시작값, 마지막 값

while start <= end:
    mid = (start + end) // 2    # 중간값 저장
    total = 0                   # 총 자른 나무 길이
    for i in trees:
        if i > mid:             # 자른 길이보다 나무의 길이가 길 때(자를 양이 있을 때)
            total += (i - mid)
    if total < M:   # 총 자른 나무 길이가 필요한 양에 미치지 못할 때
        end = mid - 1
        continue
    start = mid + 1 # 총 자른 나무 길이가 필요한 양과 같거나 더 많을 때
print(end)