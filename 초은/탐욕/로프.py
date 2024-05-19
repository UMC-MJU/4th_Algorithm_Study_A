# https://www.acmicpc.net/problem/2217

N = int(input())
K = []
for _ in range(N):
    K.append(int(input()))
K.sort()

answers = []
for i in K:
    answers.append(i * N)
    N -= 1
print(max(answers))

