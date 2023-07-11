# 수 찾기 https://www.acmicpc.net/problem/1920

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
M = int(input())
targetArr = list(map(int, input().split()))

def binarySerach(arr, value):
    answer = 0
    # 탐색 시작 값과 끝 값 설정
    first = 0
    last = len(arr)-1

    while first <= last:
        mid = int((first + last) / 2)  # 중간 값 설정
        if arr[mid] == value:
            answer = 1
            break
        elif arr[mid] > value:
            last = mid - 1
        elif arr[mid] < value:
            first = mid + 1
    print(answer)

for i in range(len(targetArr)):
    binarySerach(arr, targetArr[i])
