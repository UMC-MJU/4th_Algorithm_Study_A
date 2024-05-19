# https://www.acmicpc.net/problem/2961

def dfs(depth, start):
    global result
    # 기저
    if depth == len_:  # 만약 깊이가 뽑을 개수와 같다면(len_개 만큼 뽑았다면)
        sour = 1
        bitter = 0
        for i in arr:  # 뽑은 신맛 쓴맛을 계산
            sour *= i[0]
            bitter += i[1]
        if abs(bitter - sour) < result:
            result = abs(bitter - sour)
        return
    # 재귀
    for i in range(start, N):
        arr.append(cuisine[i])
        dfs(depth + 1, i + 1)
        arr.pop()


N = int(input())
cuisine = [list(map(int, input().split())) for i in range(N)]
arr = []
result = 10**100

for i in range(1, N + 1):
    len_ = i
    dfs(0, 0)

print(result)
