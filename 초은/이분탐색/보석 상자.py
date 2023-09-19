# https://www.acmicpc.net/problem/2792
import math, sys

input = sys.stdin.readline

# 아이들 수 N, 색상 수 M, 각 색상 보석 개수 jewels
N, M = map(int, input().split())
jewels = [int(input()) for i in range(M)]
start, end = 1, max(jewels)  # 이분탐색 시작값, 마지막 값

while start <= end:
    mid = (start + end) // 2  # 중간값 저장
    num_child = 0

    for i in jewels:
        num_child += math.ceil(i / mid)    # 소수점 올림

        if num_child > N:   # 더 이상 나눠줄 사람이 없으면 반복문 종료
            break

    # 보석은 남고, 나눠줄 사람은 부족하면 mid는 증가
    if num_child > N:
        start = mid + 1
        continue
    # 보석이 남지 않으면 mid는 감소
    end = mid - 1

# 질투심이 가장 적은 값 출력
print(start)