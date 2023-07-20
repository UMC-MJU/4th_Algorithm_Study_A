# 공유기 설치 ( https://www.acmicpc.net/problem/2110 )

import sys

input = sys.stdin.readline

# N = 집의 개수 / C = 공유기의 개수
N, C = map(int, input().split())

arr = []
for _ in range(N):
    arr.append(int(input()))

arr.sort()  # 오름차순 정렬. O(nlogn)

# 이분탐색 시작, 끝 범위 설정. 집 좌표가 아닌 거리를 탐색하는 것이 포인트
start = 1
end = arr[-1] - arr[0]


def binary_search(arr, start, end):
    answer = 0

    while start <= end:
        mid = (start + end) // 2
        current = arr[0]
        count = 1

        # mid 거리 만큼 집을 건너뛰며 공유기를 설치해보고 개수를 비교한다
        for i in range(1, N):
            # (현재 집 좌표 + 테스트 중인 거리 <= 다음 집 좌표)라면 공유기 설치
            if arr[i] >= current + mid:
                current = arr[i]  # 공유기 설치
                count += 1  # 공유기 설치 개수 +1

        # 갯수가 공유기 개수보다 많으면 mid기준 오른쪽 범위를 탐색한다.
        if count >= C:
            start = mid + 1
            answer = mid
        # 갯수가 공유기 개수보다 적으면 mid기준 왼쪽 범위를 탐색한다.
        else:
            end = mid - 1

    return answer


answer = binary_search(arr, start, end)
print(answer)
