# https://www.acmicpc.net/problem/18352

import sys
from collections import deque
input = sys.stdin.readline

# 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]# 간선(도로) 저장 2차원 배열
distance = [0] * (N+1)          # 도시 별 X부터의 거리 배열
visited = [False]*(N + 1)       # 방문했던 도시 배열

#도로 저장
for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)

def bfs(start):
    answer = []
    q = deque([start])      # 시작하는 도시 큐에
    visited[start] = True   # 방문한 도시는 True로
    distance[start] = 0     # 거리 초기화
    
    while q:
        now = q.popleft()   # 현재 있는 도시 now에 저장
        
        for i in graph[now]:
            if not visited[i]: # 방문하지 않았다면 거리는 현재 도시에 누적된 값 + 1로 저장
                visited[i] = True
                q.append(i)     
                distance[i] = distance[now] + 1
                if distance[i] == K:    # K에 만족하는 거리라면 answer에 저장
                    answer.append(i)
    # 결과 출력
    if len(answer) == 0:
        print(-1)
    else:
        answer.sort()
        for i in answer:
            print(i, end='\n')


bfs(X)      # X부터 시작