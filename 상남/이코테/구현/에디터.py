# import sys
# input = sys.stdin.readline
# n = list(input())
# l = int(input())
# data = [list(input().split()) for i in range(l)]
#
# cursor = len(n)
#
# for i in data:
#     if i[0] =="P":
#         n.insert(cursor,i[1])
#         cursor += 1
#     elif i[0] == "L":
#         if cursor == 0:
#             continue
#         cursor -= 1
#     elif i[0] == "B":
#         if cursor == 0:
#             continue
#         n.pop(cursor-1)
#         cursor -= 1
#     else:
#         if cursor == len(n):
#             continue
#         cursor += 1
#
# print("".join(n))

import sys
input = sys.stdin.readline
left = list(input().rstrip())
right = []
l = int(input())
data = [list(input().split()) for i in range(l)]

for i in data:
    if i[0] =="P":
        left.append(i[1])
    elif i[0] == "L":
        if len(left) == 0:
            continue
        right.append(left.pop())
    elif i[0] == "B":
        if len(left) == 0:
            continue
        left.pop()
    else:
        if len(right) == 0:
            continue
        left.append(right.pop())
right = list(reversed(right))
print("".join(left+right))
