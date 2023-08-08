# https://www.acmicpc.net/problem/15663

import sys

input = sys.stdin.readline
N, M = map(int, input().split())
numbers = sorted(list(map(int, input().split())))
visited = [False] * N
answer = []

def dfs():
    if len(answer) == M:    # 길이가 M이 되면 종료
        print(*answer)
        return
    remember = 0    # 같은 수열을 다시 저장하는 것 방지

    for i in range(N):
        # 방문한 적이 없고, 같은 수열이 존재하지 않을 때
        if not visited[i] and remember != numbers[i]:
            visited[i] = True
            answer.append(numbers[i])
            remember = numbers[i]
            dfs()
            # 다른 계산에서 사용할 수 있도록 방문 기록 제거
            visited[i] = False
            answer.pop()

dfs()