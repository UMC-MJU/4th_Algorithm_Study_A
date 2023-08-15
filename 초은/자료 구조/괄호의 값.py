# https://www.acmicpc.net/problem/2504

arr = list(input())

stack = []
answer = 0  # 정답 저장
tmp = 1     # 임시 변수

for i in range(len(arr)):

    if arr[i] == "(":           # 계산 시작, (는 *2
        stack.append(arr[i])
        tmp *= 2

    elif arr[i] == "[":         # 계산 시작, [는 *3
        stack.append(arr[i])
        tmp *= 3

    elif arr[i] == ")":         # ) 앞에 (가 있을 때 계산 마무리
        if not stack or stack[-1] == "[":
            answer = 0
            break
        if arr[i-1] == "(":
            answer += tmp
        stack.pop()     # 스택에 저장했던 ( 삭제
        tmp //= 2

    else:                       # ] 앞에 [가 있을 때 계산 마무리
        if not stack or stack[-1] == "(":
            answer = 0
            break
        if arr[i-1] == "[":
            answer += tmp

        stack.pop()     # 스택에 저장했던 [ 삭제
        tmp //= 3

if stack:       # 스택이 없을 때 (없으면 에러)
    print(0)
else:
    print(answer)