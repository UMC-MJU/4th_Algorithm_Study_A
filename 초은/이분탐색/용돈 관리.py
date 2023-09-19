# https://www.acmicpc.net/problem/6236

# 돈을 사용할 일수 N, 인출할 횟수 M
N, M = map(int, input().split())
list = [int(input()) for i in range(N)]
start, end = max(list), N*10000  # 이분탐색 시작값, 마지막 값

while start <= end:
    mid = (start + end) // 2  # 중간값 저장

    count_M = 1     # 첫 번째는 무조건 인출했으므로 1로 시작
    wallet = mid    # 현우가 현재 지갑에 가지고 있는 돈

    for need in list:

        # 필요한 돈이 지갑에 있는 돈으로 충분할 때
        if wallet >= need:
            wallet -= need
        # 부족하면 한번 더 인출
        else:
            count_M += 1
            wallet = mid - need

        # 인출 횟수가 M을 넘으면 반복할 필요 X
        if count_M > M:
            break

    # 인출 횟수가 M을 넘으면 인출 금액을 늘려야 한다
    if count_M > M:
        start = mid + 1
        continue
    # 인출 횟수가 M을 넘지 않으면 금액을 줄인다.
    end = mid - 1

print(start)