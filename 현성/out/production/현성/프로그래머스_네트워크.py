def solution(network, computers):
    answer = 0
    visited = [False for i in range(network)]
    for com in range(network):
        if visited[com] == False:
            DFS(network, computers, com, visited)
            answer += 1 #DFS로 최대한 컴퓨터들을 방문하고 빠져나오게 되면 그것이 하나의 네트워크.
    return answer

def DFS(network, computers, com, visited):
    visited[com] = True
    for connect in range(network):
        if connect != com and computers[com][connect] == 1: #연결된 컴퓨터
            if visited[connect] == False:
                DFS(network, computers, connect, visited)