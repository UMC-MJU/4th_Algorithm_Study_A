# https://school.programmers.co.kr/learn/courses/30/lessons/17679

def solution(m, n, board):
    blocks = []
    answer = 0
    for i in range(m):
        blocks.append(list(board[i]))
    while True:
        count, blocks = searchBlocks(m, n, blocks)
        answer += count
        # 2x2 블럭이 더 없으면 반복문 종료
        if count == 0:
            break

    return answer


# 2x2 블럭 확인 함수
def searchBlocks(m, n, blocks):
    visited = [[False] * n for _ in range(m)]
    count = 0

    for i in range(m - 1):
        for j in range(n - 1):
            # 블럭이 존재하면서, 왼, 아래, 대각선과 같은 블럭일 때
            if blocks[i][j] != -1 and blocks[i][j] == blocks[i][j + 1] == blocks[i + 1][j] == blocks[i + 1][j + 1]:
                # 블럭 중복 확인 후 count + 1
                if not visited[i][j]:
                    visited[i][j] = True
                    count += 1
                if not visited[i][j + 1]:
                    visited[i][j + 1] = True
                    count += 1
                if not visited[i + 1][j]:
                    visited[i + 1][j] = True
                    count += 1
                if not visited[i + 1][j + 1]:
                    visited[i + 1][j + 1] = True
                    count += 1

    return count, deleteBlocks(m, n, blocks, visited)


# 블럭을 아래로 내리는 함수
def deleteBlocks(m, n, blocks, visited):
    
    stack = []
    for j in reversed(range(n)):
        # 터트리지 않은 블럭들 스택에 저장
        for i in reversed(range(m)):
            if not visited[i][j]:
                stack.append(blocks[i][j])
        # 아래부터 스택에 있는 값 채워주고 나머지는 -1로 초기화
        for i in range(m):
            if stack:
                if i < m - len(stack):
                    blocks[i][j] = -1
                else:
                    blocks[i][j] = stack.pop()

    return blocks


# 출력 예시
m = 6
n = 6
board = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]
print(solution(m, n, board))
