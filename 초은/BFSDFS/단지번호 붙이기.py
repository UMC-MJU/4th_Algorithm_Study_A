# https://www.acmicpc.net/problem/2667

#DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
def dfs(x, y):
    #주어진 범위를 벗어나는 경우에는 즉시 종료
    if x <= -1 or x >= line_num or y <= -1 or y >= line_num:
        return False

    #현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 1:
        #집의 갯수 +1
        global count
        count += 1
        #해당 노드 방문 처리
        graph[x][y] = 0
        #상,하,좌,우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

line_num = int(input())

graph = []
for i in range(line_num):
    graph.append(list(map(int, input())))

#모든 노드(위치)에 대하여 이웃집 확인하기
result = 0
num = []
count = 0
for i in range(line_num):
    for j in range(line_num):
        #현재 위치에서 DFS 수행
        if dfs(i, j) == True:
            result += 1
            num.append(count)
            count = 0
#오름차순 정렬
num.sort()

#단지 수 출력
print(result)
#단지 내 집의 수
for i in range(len(num)):
    print(num[i])