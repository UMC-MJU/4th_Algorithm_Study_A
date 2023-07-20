# [입력 조건]첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1<=N,M<=1000)
#           두 번째 줄부터 N+1번째 줄까지 얼음 틀의 형태가 주어진다.
#           구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
# 0이 연결되어 있으면 하나의 아이스크림.
# [출력 조건]한 번에 만들 수 있는 아이스크림의 개수를 출력.


#DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
def dfs(x, y):
    #주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    #현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        #해당 노드 방문 처리
        graph[x][y] = 1
        #상, 하, 좌, 우의 노드들도 모두 재귀적으로 호출 -> 방문하기
        dfs(x, y+1)
        dfs(x, y-1)
        dfs(x-1, y)
        dfs(x+1, y)
        return True
    return False


#N, M을 공백을 기준으로 구분하여 입력 받기
n, m = map(int, input().split())

#2차원 리스트의 맵 정보 입력 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

#모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)