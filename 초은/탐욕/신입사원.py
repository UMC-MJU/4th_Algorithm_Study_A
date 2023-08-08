# https://www.acmicpc.net/problem/1946
import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n = int(input())
    people_list = [0] * n

    # 면접 결과 입력받기
    for i in range(n):
        t1, t2 = map(int, input().split())
        people_list[i] = [t1, t2]

    # 서류 평가로 정렬하기
    people_list.sort()

    # 서류심사 1등은 무조건 합격
    hired = 1
    x = people_list[0][1]

    for i in range(1, n):
        if people_list[i][1] < x:   # i번째 사람이 그 전 최고 등수보다 등수가 더 높을 때 합격
            hired += 1
            x = people_list[i][1]

    print(hired)