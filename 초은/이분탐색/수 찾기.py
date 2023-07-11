# https://www.acmicpc.net/problem/1920

import sys

input = sys.stdin.readline
N = int(input())    # 비교 당할 자연수 입력받기
target_list = list(map(int, input().strip().split()))
M = int(input())    # 비교할 자연수 입력받기
test_list = list(map(int, input().strip().split()))

target_list.sort()  # 예산, 나무자르기 문제와 다르게 
                    # 배열의 값들 중 찾기 때문에 정렬 필요

for i in test_list:
    left, right = 0, len(target_list) - 1
    exist = False
    while left <= right:
        mid = (left + right) // 2   # 인덱스 중간값 저장
        if target_list[mid] == i:   # 일치할 때
            exist = True            
            break
        elif target_list[mid] > i:  # 찾는 값보다 클 때
            right = mid - 1
        else:
            left = mid + 1          # 찾는 값보다 작을 때

    if exist:
        print(1)
        continue
    print(0)