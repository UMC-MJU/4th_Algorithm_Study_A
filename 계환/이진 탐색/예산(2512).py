# 예산 ( https://www.acmicpc.net/problem/2512 )

N = int(input())  # 지방의 수
arr = list(map(int, input().split()))  # 각 지방의 예산 요청 리스트
arr.sort()  # 오름차순으로 정렬
total = int(input())

start = 0      # 예산 요청의 시작값
end = arr[-1]  # 예산 요청의 최대값

answer = 0  # 최대 상한액

while start <= end:
    mid = (start + end) // 2  # 상한액을 이분 탐색으로 찾기

    total_budget = 0  # 상한액을 적용한 총 예산
    for budget in arr:
        if budget <= mid:
            total_budget += budget
        else:  # 예산 요청액이 중간 값보다 크다면 요청액 그대로가 아닌 중간값으로 예산을 먼저 책정한다.
            total_budget += mid

    if total_budget <= total:  # 상한액으로 배정한 예산이 총 예산 이하인 경우
        answer = mid
        start = mid + 1  # 더 큰 상한액을 탐색하기 위해 범위를 오른쪽으로 이동
    else:  # 상한액으로 배정한 예산이 총 예산을 초과하는 경우
        end = mid - 1  # 더 작은 상한액을 탐색하기 위해 범위를 왼쪽으로 이동

print(answer)
