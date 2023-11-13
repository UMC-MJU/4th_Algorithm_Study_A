# https://www.acmicpc.net/problem/1197

import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())
visited = [False] * (V + 1)     # 방문 노드 저장
Elist = [[] for _ in range(V + 1)]  # 간선 저장
heap = [[0, 1]]     # 현재 그래프에서 짧은 경로 저장

# 간선 입력받기
for _ in range(E):
    s, e, w = map(int, input().split())
    # 양방향 모두 저장
    Elist[s].append([w, e])
    Elist[e].append([w, s])

answer = 0
cnt = 0
while heap:
    # 모두 돌았을 때 종료
    if cnt == V:
        break
    w, s = heapq.heappop(heap)
    # 도착한 노드가 첫 방문일 때만
    if not visited[s]:
        visited[s] = True
        answer += w
        cnt += 1
        # 현재 그래프에서 가장 짧은 간선이 가장 앞에 저장 (heap property 유지)
        for i in Elist[s]:
            heapq.heappush(heap, i)

print(answer)