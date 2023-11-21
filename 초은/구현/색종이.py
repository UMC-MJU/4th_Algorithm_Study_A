# https://www.acmicpc.net/problem/2563
arr = [[False for _ in range(101)] for _ in range(101)]
N = int(input())    # 색종이 개수

for _ in range(N):
    x, y = list(map(int, input().split()))  # 색종이 시작점

    # 색종이 붙여진 위치만큼 2차원배열에 표시 -> 색종이 겹쳐도 문제X
    for row in range(x, x + 10):
        for col in range(y, y + 10):
            arr[row][col] = True

result = 0

# 영역 넓이 출력
for i in arr:
    result += i.count(True)
print(result)
