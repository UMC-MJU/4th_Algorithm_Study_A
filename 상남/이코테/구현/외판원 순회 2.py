# # n = int(input())
# # w = [[0]*(n+1) for _ in range(n+1)]
# # for i in range(1,n+1):
# #     data = list(map(int,input().split()))
# #     for j in range(n):
# #         w[i][j] = data[j]
# # print(w)
# #
# # visited = [[False]*(n+1) for _ in range(n+1)]
# #
# # def dfs(v):
# #     if v == n+1:
# #         pass
# #     else:
# #
# # for i in range(1,n+1):
# #     tmp = dfs(i)
#
#
# import sys
#
# input = sys.stdin.readline
# n = int(input())
# costs = [list(map(int, input().split())) for _ in range(n)]
# visited = [0] * n  # 방문했는지 안했는지
#
#
# def dfs(start, cost, count):
#     global ans
#     if count == n - 1 and costs[start]: # 종료 조건
#
#         return
#     for i in range(n):
#         if visited[i] == 0 and costs[start][i]: # 방문 안한 도시 일떄
#             visited[i] = 1 # 방문 체크
#             dfs(i, cost+costs[start][i],count + 1) # 재귀
#             visited[i] = 0 # 재귀가 끝나면 초기화
#
#
# dfs(0, 0, 0)
# print(ans)
def dfs(start,cost,count):
    global result
    # 횟수가 n-1번이다 -> 모든 도시 다 돌았다.
    # arr[start][0] != 0 마지막 지점에서 1로 돌아가는 길이 있다
    if count == n-1 and arr[start][0] != 0:
    	# 최소값은 비용에다가 돌아가는 비용 더한거랑 비교
        result = min(result,cost+arr[start][0])
        return

    for i in range(n):
        if visited[i] == 0 and arr[start][i] != 0:
            visited[i] = 1
            # 출발지점을 i로
            # 비용에 i로 가는 비용 더해주기
            # 횟수 + 1
            dfs(i,cost+arr[start][i],count+1)
            visited[i] = 0

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

# 방문 확인을 위한 visited
# 1부터 n까지만 확인하면 되므로
visited = [0] * n
print(visited)

result = int(1e9)

visited[0] = 1
# 시작지점, 비용, 횟수
dfs(0,0,0)
print(result)