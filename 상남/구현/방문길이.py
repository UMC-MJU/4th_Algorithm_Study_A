def solution(dirs):
    sets = set()
    y, x = 0, 0
    udrl = {'U': (1, 0), 'D': (-1, 0), 'R': (0, 1), 'L': (0, -1)}

    for d in dirs:
        dy, dx = udrl[d]
        ny = y + dy
        nx = x + dx
        if -5 <= ny <= 5 and -5 <= nx <= 5:
            sets.add(((y, x), (ny, nx)))
            sets.add(((ny, nx), (y, x)))
            y = ny
            x = nx
    return len(sets) // 2


from collections import deque


def solution(dirs):
    cnt = 0
    d = {
        "U": [0, 1],
        "D": [0, -1],
        "L": [-1, 0],
        "R": [1, 0]
    }

    vx = [[0] * (11) for _ in range(11)]
    vy = [[0] * (11) for _ in range(11)]

    # q = deque()
    # q.append((0,0))

    x, y = 0, 0
    for dir in dirs:
        print(x, y, dir)
        if dir == "U":
            nx, ny = d["U"]
        elif dir == "D":
            nx, ny = d["D"]
        elif dir == "L":
            nx, ny = d["L"]
        else:
            nx, ny = d["R"]

        tx = x + nx
        ty = y + ny

        if tx < 0:
            tx = tx * -1
        elif ty < 0:
            ty = ty * -1

        if tx > 10 or ty > 10:
            continue

        if vx[x][tx] == 1 and vy[y][ty] == 1:
            continue
        else:
            # q.append((tx,ty))
            cnt += 1
            vx[x][tx] = 1
            vy[y][ty] = 1
            x, y = tx, ty

    print(cnt)