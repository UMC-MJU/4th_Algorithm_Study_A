# https://www.acmicpc.net/problem/4673

def d(n):
    # d(n)을 계산하는 식
    n = n + sum(map(int, str(n)))
    return n

nonSelfNum = []

for i in range(1, 10001):
    nonSelfNum.append(d(i))

for j in range(1, 10001):
    if j not in nonSelfNum:
        print(j)