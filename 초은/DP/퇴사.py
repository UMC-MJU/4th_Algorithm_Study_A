# https://www.acmicpc.net/problem/14501
import sys

N = int(input())
graph = [[0, 0] for _ in range(N)]
for n in range(N):
    T, P = map(int, sys.stdin.readline().split())
    if n + T <= N:
        graph[n] = [T, P]

# hint: 뒤에서부터 풀기
