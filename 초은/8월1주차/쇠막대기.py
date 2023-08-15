# https://www.acmicpc.net/problem/10799

data_input = list(input())
stack = []
count = 0

for i in range(len(data_input)):
    if data_input[i] == '(':
        stack.append('(')   # 막대 시작
        if data_input[i + 1] == ')':
            stack.pop()     # 막대가 아니라 레이저였다!
            count += len(stack) # 지금까지 막대들 한번 더해주기
    else:
        if data_input[i - 1] == '(':    # 레이저인 경우는 세지X
            continue
        stack.pop()         # 막대 끝
        count += 1

print(count)