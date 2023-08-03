# n,s = map(int, input().split())
# data = list(map(int, input().split()))
# res = [0] *(n)
# cnt = 0
# def dfs(v,sum):
#     global cnt
#     if sum == s:
#         cnt += 1
#     if v == n:
#         return
    
#     dfs(v+1,sum+data[v])
#     dfs(v+1,sum)

# dfs(0,0)

# print(cnt)

# n,s = map(int, input().split())
# data = list(map(int, input().split()))
# res = [0] *(n)
# cnt = 0
# def dfs(v,sum):
#     global cnt
#     if v == n: # 개수를 넘어가면 안되므로 그전에 return
#         return
#     sum += data[v]  # data[v] 값을 일단 더한다.
#     if sum == s: # 만약 합값이 s값이라면 개수 추가
#         cnt += 1
    
#     dfs(v+1,sum)    # 숫자를 선택하는 경우
#     dfs(v+1,sum-data[v])    # 숫자를 선택하지 않는 경우

# dfs(0,0)

# print(cnt)

n,s = map(int, input().split())
data = list(map(int, input().split()))
res = [0] *(n)
cnt = 0
def dfs(v,sum):
    global cnt
    if sum == s:
        cnt += 1
    if v == n:
        return
    
    dfs(v+1,sum+data[v])
    dfs(v+1,sum)

dfs(0,0)

print(cnt)