# https://www.acmicpc.net/problem/10971

import sys

N = int(input())
travel_cost = [list(map(int, input().split())) for _ in range(N)]
# 최소값 정의
min_value = sys.maxsize


def dfs(start, nxt, value, visited):
    global min_value

    if len(visited) == N:
        # nxt에서 start로 이동이 가능할 때
        if travel_cost[nxt][start] != 0:
            min_value = min(min_value, value + travel_cost[nxt][start])
        return

    for i in range(N):
        # 이동이 가능하고 현재 최솟값보다 비용이 저렴할 때
        if travel_cost[nxt][i] != 0 and i not in visited and value < min_value:
            visited.append(i)
            dfs(start, i, value + travel_cost[nxt][i], visited)
            visited.pop()

# 모든 도시에서 출발
for i in range(N):
    dfs(i, i, 0, [i])

print(min_value)
