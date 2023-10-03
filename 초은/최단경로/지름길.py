# https://www.acmicpc.net/problem/1446

# 지름길의 개수, 고속도로 길이 저장
N, D = map(int, input().split())
# 지름길의 시작위치, 도착위치, 길이
li = [list(map(int, input().split())) for _ in range(N)]
# 0~D까지 저장
dis = [i for i in range(D+1)]

for i in range(0, D+1):
    # 더 짧은 거리로 저장
    dis[i] = min(dis[i], dis[i-1]+1)

    for start, end, distance in li:
        # 범위에 해당하고, start가 현재 위치일 때 비교
        if i == start and end <= D and dis[i]+distance < dis[end]:
            dis[end] = dis[i]+distance

# 최소값인 가장 마지막 거리 출력
print(dis[D])