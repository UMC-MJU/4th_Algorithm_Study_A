# https://www.acmicpc.net/problem/1018

N, M = map(int, input().split())
board = []
for _ in range(N):
    board.append(input())

# 다시 칠해야 하는 정사각형 개수 계산
min_changes = float('inf')

chessboard1 = ['WB' * 4, 'BW' * 4] * 4
chessboard2 = ['BW' * 4, 'WB' * 4] * 4

for i in range(N - 7):
    for j in range(M - 7):

        # 첫 번째 칸을 기준으로 8x8 체스판 생성
        changes1 = 0
        changes2 = 0

        for x in range(8):
            for y in range(8):
                # 현재 칸이 chessboard1과 다른 경우
                if board[i + x][j + y] != chessboard1[x][y]:
                    changes1 += 1
                # 현재 칸이 chessboard2와 다른 경우
                if board[i + x][j + y] != chessboard2[x][y]:
                    changes2 += 1

        # chessboard1으로 시작하는 경우와 chessboard2로 시작하는 경우 중 더 적은 변경 횟수 선택
        min_changes = min(min_changes, changes1, changes2)

print(min_changes)
