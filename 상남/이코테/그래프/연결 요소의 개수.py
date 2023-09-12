from collections import deque
import sys
input = sys.stdin.readline
n,m = map(int, input().split())
data = [list(map(int,input().split())) for _ in range(m)]

def bfs(v): # bfs를 돌린다.
    q = deque()
    q.append(v)

    while q:
        tmp = q.popleft()

        for i in graph[tmp]:
            if visited[i] == False: # 방문이 안되어있다면
                visited[i] = True # 방문 처리를 해준 후 q에 노드 값을 넣어준다.
                q.append(i)
graph = [[] for _ in range(n+1)]
visited = [False] *(n+1)
for a,b in data:
    graph[a].append(b) # 무방향이라고 했으니 둘다 연결해준다.
    graph[b].append(a)


cnt = 0
for i in range(1,n+1):
    
    if visited[i] == False: # 방문이 안되어 있다면
        bfs(i)
        cnt += 1 # 한군데를 둘렀으면 + 1
print(cnt)
