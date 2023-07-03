# https://www.acmicpc.net/problem/2606

import sys
# 파이썬에서 재귀를 사용해 문제를 풀 때 필수로 넣어줘야 함(기본 재귀 깊이 제한은 1000으로 매우 얕은 편)
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

com = int(input())  # 컴퓨터 수
con = int(input())  # 연결 수

# 정점의개수+1만큼의 간선을 나타내는 배열을 만들기(2차원)
# index가 0부터 시작하기 때문에 com+1로 제작. index==0인 부분은 사용X
graph = [[False] * (com + 1) for _ in range(com + 1)]  #
# 정점의 개수+1개인 방문했던 배열 만들기(1차원)
visited = [False]*(com + 1)

#간선 저장
for i in range(con):
    x, y = map(int, input().split())
    # 양방향이기 때문 x->y, y->x
    graph[x][y] = True
    graph[y][x] = True

def dfs(V):
    global count
    # 방문했음을 나타내도록 visited true로 바꿔주기
    visited[V] = True
    count += 1
    for i in range(1, com + 1):
        # i 정점이 False이면서, graph[V][i]==True, 즉 방문한 적 없는 간선이 존재할 때
        if not visited[i] and graph[V][i]:
            # 재귀함수 호출
            dfs(i)

count = 0   # 전역변수 초기화
dfs(1)      # 1부터 시작
print(count - 1)    # 1로부터 바이러스가 걸린 컴퓨터 개수이므로 1 빼주기
