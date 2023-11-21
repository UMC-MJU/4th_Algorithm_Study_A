# https://www.acmicpc.net/problem/11726
n = int(input())
arr = [0, 1, 2]

# 피보나치 f(n) = f(n-1) + f(n-2)
for i in range(3, n + 1):
    arr.append(arr[i - 1] + arr[i - 2])

print(arr[n] % 10007)
