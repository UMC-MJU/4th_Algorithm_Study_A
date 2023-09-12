# 상하좌우 이코테 111p
# 첫째줄에 지도의 크기 N
# 둘째줄에 이동 계획서
# 도착 지점의 좌표를 구하는 프로그램

def solution():
    n = int(input())
    x, y = 1, 1
    plans = input().split()
    # L, R, U, D
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    move_types = ['L, R, U, D']
    for i in plans:
        for j in range(len(move_types)):
            if i == move_types[j]:
                nx = x + dx[j]
                ny = y + dy[j]
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        x, y = nx, ny

    print(x, y)

