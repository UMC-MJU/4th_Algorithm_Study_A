# https://www.acmicpc.net/problem/1051

def squre(s):
    for i in range(N-s+1):
        for j in range(M-s+1):
            if numbers[i][j] == numbers[i][j+s-1] == numbers[i+s-1][j] == numbers[i+s-1][j+s-1]:
                return True
    return False


N, M = map(int, input().split())
numbers = [list(map(int, list(input()))) for _ in range(N)]

size = min(N, M)

# 최대 크기부터
for k in range(size, 0, -1):
    if squre(k):
        print(k**2)
        break
