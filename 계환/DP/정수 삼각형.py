import copy

def solution(triangle):
    answer = 0
    dp = copy.deepcopy(triangle)  # triangle은 값을 바꾸지 않음.

    for i in range(len(dp) - 1):
        for j in range(len(dp[i])):
            if (triangle[i + 1][j] + dp[i][j] > dp[i + 1][j]):
                dp[i + 1][j] = triangle[i + 1][j] + dp[i][j]

            if (triangle[i + 1][j + 1] + dp[i][j] > dp[i + 1][j + 1]):
                dp[i + 1][j + 1] = triangle[i + 1][j + 1] + dp[i][j]

    answer = max(dp[len(dp)-1])
    return answer
