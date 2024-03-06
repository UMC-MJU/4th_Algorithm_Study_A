# https://www.acmicpc.net/problem/3098

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

days = 0
friends = []
while True:
    answer = 0
    for a in range(1, N + 1):
        answer += len(graph[a])

    # 모두 돌았으면 종료
    if answer == N * (N - 1):
        break

    # 순서X, 중복X set
    friend = set()
    for i in range(1, N + 1):
        for j in graph[i]:
            for k in graph[j]:
                if i != k and k not in graph[i]:
                    if i <= k:
                        friend.add((i, k))
                    else:
                        friend.add((k, i))

    for a, b in friend:
        graph[a].append(b)
        graph[b].append(a)

    # 하루 추가
    days += 1 
    friends.append(len(friend))

print(days)
for f in friends:
    print(f)
