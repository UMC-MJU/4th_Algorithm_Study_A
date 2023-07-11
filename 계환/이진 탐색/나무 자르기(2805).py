# 나무 자르기 ( https://www.acmicpc.net/problem/2805 )

N, minTree = map(int, input().split())  # 나무의 수, 필요한 나무 길이
arr = list(map(int, input().split()))  # 나무의 높이 리스트
arr.sort()  # 오름차순 정렬

answer = 0  # 높이의 최댓값
start = 0
end = arr[-1]

while start <= end:
    mid = (start + end) // 2   # 중간값으로 자른 후 결과에 따라서 중간값을 조금씩 변경한다.
    cutTree = 0  # 자른 나무 길이의 총 합
    for tree in arr:
        # 나무가 잘리면 자른 나무의 길이를 총 합에 더한다
        if mid < tree:
            cutTree += tree - mid  #

    # 아래 for문을 쓰면 시간초과 판정.
    # for i in range(len(arr)):
    #     if mid < arr[i]:
    #         cutTree += (arr[i] - mid)

    # 필요한 나무보다 더 많이 잘랐다면, 자를 높이를 높여준다.
    if minTree <= cutTree:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)
