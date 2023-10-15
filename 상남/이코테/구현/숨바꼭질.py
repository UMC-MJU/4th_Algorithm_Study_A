from collections import deque
n,k = map(int, input().split())

q = deque()
q.append(n)
cnt = 0
visited = [0]*100001
while q:
    x = q.popleft()
    if x == k: # 목표값이라면
        print(visited[x])
        break

    for i in x-1,x+1,2*x:
        if 0 <= i <=100000 and visited[i] == 0 :
            # visited[i] == 0 and 0 <= i <= 100000 이렇게 조건문을 세우면 안됨 --> 제가 알기로는 앞에서부터 차례대로 검색을 하는데 예를 들어 i가 100000 초과가 되면 visited[i]는 인덱스에러를 나타나게 된다.
            visited[i] = visited[x] + 1 # dfs로 치면 밑으로 들어간다.
            q.append(i)


# 직접 그림을 그려보니 dfs를 생각했다. 하지만 뭔가 적용이 잘 안됐고 dfs와 bfs 차이를 구글링하며 풀게되었다.

# DFS vs BFS
#
# 문제를 보자마자 어떤 search를 진행할 것인지 판단할 수 있어야 합니다. 간단하게 정리를 해보자면,
#
# DFS가 유리한 경우
# - 재귀적인 특징과 백트래킹을 이용하여 모든 경우를 하나씩 전부 탐색하는 경우
# - Graph의 크기가 클 경우
# - Optimal한 답을 찾는 것이 아닌 경우
# - 경로의 특징을 저장해야 하는 경우 ex) 경로의 가중치, 이동 과정에서의 제약
# BFS가 유리한 경우
# - 최단 거리 or 최단 횟수 구하는 경우
# - Optimal한 답을 찾는 경우, BFS는 가장 처음 발견되는 해답이 최단 거리이다!
# - 탐색의 횟수를 구해야 하는 경우(7576번 토마토 문제)
# 그렇다면, 해당 문제는 BFS를 사용하는 것이 유리합니다!