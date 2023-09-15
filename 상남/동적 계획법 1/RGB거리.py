n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
# dp[0] = min(data[0])
# tmp = data[0].index(min(data[0]))
# print(tmp)
# for i in range(1,len(data)):
    
#     if tmp == 0:
#         dp[i] = dp[i-1] + min(data[i][1],data[i][2])
#         tmp = data[i].index(min(data[i][1],data[i][2]))
#     elif tmp == 1:
#         dp[i] = dp[i-1] + min(data[i][0],data[i][2])
#         tmp = data[i].index(min(data[i][0],data[i][2]))
#     else:
#         dp[i] = dp[i-1] + min(data[i][0],data[i][1])
#         tmp = data[i].index(min(data[i][0],data[i][1]))

#     if i[0] == i[1] and i [0] == i[2]:
#     print(tmp)
# print(dp)

for i in range(1,n):
    for j in range(3):
        if j == 0:
            data[i][0] = data[i][0] + min(data[i-1][1],data[i-1][2]) # 첫열이라면 이전 행의 두번째열과 세번째열을 비교한다.
        elif j == 1:
            data[i][1] = data[i][1] + min(data[i-1][0],data[i-1][2]) # 두번째 열이라면 이전 행의 첫번째열과 두번째열을 비교한다.
        else:
            data[i][2] = data[i][2] + min(data[i-1][0],data[i-1][1]) # 세번째 열이라면 이전 행의 첫번째열과 두번째열을 비교한다.


# 밑으로 누적하면서 가장 작은값 출력
print(min(data[n-1]))


# 처음에는 가장 작은값의 인덱스를 찾아서 저장해준다음 그 변수를 다음에 접근하지 못하도록 하는 방식으로 하였지만 100 100 100 이경우에는 모두 같은 값이기때문에 인덱스를 찾는다는게 의미가 없어진다.
# 그래서 고민을 해본 결과 밑으로 누적해서 가장작은값을 찾는다는것이 좋은 방법이라는 것을 알게되었다.

