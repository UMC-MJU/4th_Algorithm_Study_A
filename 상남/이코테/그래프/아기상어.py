from collections import deque
import heapq


def bfs(q):
    global re
    vist = [[False] * n for _ in range(n)]  # 방문체크
    h = []  # 우선순위 연산을 해줄 heapq
    while q:
        x, y, c, size, up = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < n and 0 <= ny < n and not vist[nx][ny]:
                vist[nx][ny] = True  # 방문 체크
                if s[nx][ny] != 0 and s[nx][ny] < size:  # 먹을 수 있는 먹이의 위치 h에 저장
                    heapq.heappush(h, (c + 1, nx, ny))  # 우선순위 짧은 거리>높은 위치 > 왼쪽
                elif size >= s[nx][ny]:  # 지나갈 수 있는 조건
                    q.append((nx, ny, c + 1, size, up))  # 지나갈 수 있으니 추가
    if h == []:  # 아무것도 먹을 수 없으니 엄마상어 호출
        return True
    else:
        re += h[0][0]  # 우선순위에 맞는 것을 하나 먹어줌
        up += 1  # 경험치 +=1
        if up == size:  # 조건에 나와있듯이 경험치 == 크기 -> 크기+1
            up = 0
            size += 1
        s[h[0][1]][h[0][2]] = 0  # 맵에서 먹을 물고기는 지워줌
        t = deque()
        t.append((h[0][1], h[0][2], 0, size, up))  # 상어의 현 위치 갱신
        return t  # 위치 반환


n = int(input())
s = []
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]
for i in range(n):
    s2 = list(map(int, input().split()))
    for j in range(n):
        if s2[j] == 9:
            q = deque()
            q.append([i, j, 0, 2, 0])
            s2[j] = 0

    s.append(s2)
re = 0
while True:
    q = bfs(q)  # 상어의 위치 갱신
    if q == True:  # 상어의 위치가 안 바뀐거니 엄마 상어 부름
        print(re)
        break