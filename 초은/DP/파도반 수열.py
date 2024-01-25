# https://www.acmicpc.net/problem/9461
T = int(input())
for _ in range(T):
    N = int(input())

    if N < 3:
        print(1)
        continue

    count = [0] * N
    count[0] = 1
    count[1] = 1
    count[2] = 1

    for n in range(3, N):
        count[n] = count[n-2] + count[n-3]

    print(count[N-1])
