# import itertools
# import sys
# input = sys.stdin.readline
# n,k = map(int, input().split())
# data = list(map(int,input().split()))
#
# p = itertools.permutations(data,n)
# cnt = 0
# for i in p:
#     health = 500
#     for j in i:
#         health += j-k
#         if health < 500:
#             break
#     else:
#         cnt += 1
# print(cnt)

import itertools
import sys
input = sys.stdin.readline
n,k = map(int, input().split())
data = list(map(int,input().split()))
temp = [0]*n
cnt = 0
def dfs(v,health):
    global cnt
    if health < 500: # 3대 500미만이면 리턴
        return
    if v == n:
        cnt += 1
        return


    for i in range(n):
        if temp[i] == 0: # 접근안했을때만
            temp[i] = 1 # 접근하게 된다.
            dfs(v+1,health+data[i]-k)
            temp[i] = 0 # 접근한걸 취소


dfs(0,500)
print(cnt)


# 순열로 풀었습니다 하지만 연습을 하기위해 dfs로 도전해봤습니다.
# 사실상 순열을 dfs로 구현하면 되는건데 쉽지않네요 연습이 많이 필요합니다.