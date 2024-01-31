# https://www.acmicpc.net/problem/15686
import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
city = list(list(map(int, input().split())) for _ in range(n))
result = 999999
house = []      # 집의 좌표
chicken = []      # 치킨 집의 좌표

# 지도에서 집, 치킨집 위치 배열에 저장
for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append([i, j])
        elif city[i][j] == 2:
            chicken.append([i, j])

for chi in combinations(chicken, m):  # 중복 없이 m개의 치킨집 선택
    temp = 0            # 도시의 치킨 거리
    for h in house:
        chi_len = 999   # 각 집마다 치킨 거리
        for j in range(m):
            chi_len = min(chi_len, abs(h[0] - chi[j][0]) + abs(h[1] - chi[j][1]))
        temp += chi_len
    result = min(result, temp)

print(result)
# 문제는 못풀었는데 그냥 어떻게 푸는지 보고 싶어서 답변 참고,, 생각보다 길지 않게 끝나네요
