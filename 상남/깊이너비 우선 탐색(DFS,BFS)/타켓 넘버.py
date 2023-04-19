# def dfs(l,sum):
#     global cnt
#     if l == len(numbers):
#         if sum == target:
#             cnt += 1
#         return
    
#     else:
#         dfs(l+1,sum+numbers[l])
#         dfs(l+1,sum-numbers[l])

# l= 0
# cnt = 0
# sum = 0
# # numbers = [1,1,1,1,1]
# # target = 3
# numbers = [4, 1, 2, 1]
# target = 4
# dfs(l,sum)
# print(cnt)
cnt = 0
def solution(numbers, target):
    def dfs(l,sum):
        global cnt
        if l == len(numbers):
            if sum == target:
                cnt += 1
            return

        else:
            dfs(l+1, sum+numbers[l])
            dfs(l+1, sum-numbers[l])
    
    dfs(0,0)
    return cnt

print(solution([1, 1, 1, 1, 1], 3))