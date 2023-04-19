cnt = 0
def solution(numbers, target):
    
    def dfs(l,sum):
        global cnt  #전역변수 설정
        if l == len(numbers):   # number의 갯수만큼 깊게 간다면
            if sum == target:   
                cnt += 1
            return

        else:
            dfs(l+1, sum+numbers[l]) # 1개 +
            dfs(l+1, sum-numbers[l]) # 1개 -
    
    dfs(0,0)
    return cnt