# 쇠막대기 https://www.acmicpc.net/problem/10799

import sys
input = sys.stdin.readline

# 2차원 배열에 쇠막대기와 레이저 위치 정보를 저장.
info = list(input().rstrip())  # 개행 문자를 제거합니다.

stack = []
slice_sum = 0

for i in range(len(info)):
    if info[i] == '(':
        stack.append(i)
    else:  # info[i] == ')'
        if i - stack[-1] == 1:  # 레이저인 경우
            stack.pop()
            slice_sum += len(stack)
        else:  # 쇠막대기 끝인 경우
            stack.pop()
            slice_sum += 1

print(slice_sum)

# 시간초과
# graph = [[] for _ in range(len(info) // 2)]
#
# for i in range(len(info)):
#     temp = 0
#     if info[i] == '(':
#         for j in range(len(graph)):
#             if len(graph[j]) == 0:
#                 graph[j].append(i)
#                 temp = j
#                 break
#
#     elif info[i] == ')':
#         for k in range(j, -1, -1):
#             if len(graph[k]) == 1:
#                 graph[k].append(i)
#                 break
#
# razer = []
# for i in range(len(graph)):
#     if graph[i][1] - graph[i][0] == 1:
#         # 여기 들어오면 레이저인 것임.
#         razer.append(graph[i])
#
#
# slice_sum = 0
# razer_cnt = 0
# for i in range(len(graph)):
#     razer_cnt = 0
#     if graph[i][1] - graph[i][0] != 1:
#         for j in range(len(razer)):
#             if graph[i][0] < razer[j][0] < graph[i][1]:
#                 # 잘렸다면
#                 razer_cnt += 1
#         slice_sum += razer_cnt + 1
#
# print(slice_sum)
