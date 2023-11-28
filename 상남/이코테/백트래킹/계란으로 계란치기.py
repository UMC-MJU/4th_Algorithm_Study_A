import sys
input = sys.stdin.readline
n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
cnt = 0
answer = 0
def dfs(l):
    global answer
    count = 0
    if l == n:
        for i in range(n):
            if i == l:
                continue
            if data[i][0] <= 0:
                count += 1
        answer = max(count, answer)
        return

    if data[l][0] <= 0: # 지금 손에 있는 계란이 깨진 경우 -> idx+1
        dfs(l+1)
        return

    check = True # 계란이 모두 깨져있는지 확인
    for i in range(n):
        if i == l:
            continue
        if data[i][0] > 0:
            check = False
            break
    if check:  # 다 깨져있는 경우
        answer = max(answer, n - 1)  # 자기빼고 전부다니깐 N-1
        return

    for i in range(n):
        if i == l:
            continue
        if data[i][0] <= 0:
            continue
        data[l][0] -= data[i][1]
        data[i][0] -= data[l][1]
        dfs(l + 1)
        # back (깨지 않는 경우로 다시 복구)
        data[l][0] += data[i][1]
        data[i][0] += data[l][1]
dfs(0)
print(answer)