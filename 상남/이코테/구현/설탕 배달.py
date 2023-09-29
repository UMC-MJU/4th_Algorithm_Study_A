import sys
# input = sys.stdin.readline
# n = int(input())
# rst = 0
# while n>0:

#     if n == 3:
#         rst += 1
#         break
#     if n <=2:
#         rst = -1
#         break
    
#     if n%5 != 0 and n%3 != 0:
#         n -= 5
#         rst += 1
#     elif n%5 == 0:
#         rst += n // 5
#         n %= 5
#     elif n%3 == 0:
#         n -= 3
#         rst += 1
# print(rst)

input = sys.stdin.readline
n = int(input())
rst = 0
while n>0:

    if n <=2: # 설탕의 나머지가 2개이하라면 -1
        rst = -1
        break
    
    if n%5 == 0:    #5개로 나눠지면 5개로 나눈값이 답
        rst += n // 5
        n %= 5
    else: # 아니면 3개씩 제거 한다
        n -= 3
        rst += 1
print(rst)