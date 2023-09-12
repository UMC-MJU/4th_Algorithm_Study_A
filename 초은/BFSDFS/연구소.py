# https://www.acmicpc.net/problem/14502

import sys
input = sys.stdin.readline

# 세로 크기 N, 가로 크기 M
N, M = map(int, input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
