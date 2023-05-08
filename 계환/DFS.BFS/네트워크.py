
def solution(n, computers):
    answer = 0
    visited = [False] * n

    def dfs(i):
        visited[i] = True
        for j in range(n):
            if not visited[j] and computers[i][j] == 1:
                dfs(j)

    for i in range(n):
        if not visited[i]:  # 방문하지 않은 경우만
            dfs(i)
            answer += 1

    return answer