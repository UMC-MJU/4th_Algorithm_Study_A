# 큰 수의 법칙 - 가장 큰 수가 나오게 더하기
# 첫째줄에 N, M, K
# N = 자연수 개수 // M = 몇 개 더해야 하는지 // K = 같은 인덱스 몇번까지 더할 수 있는지
# 둘째줄에 N개의 자연수 주어짐

def solution():
    n, m, k = map(int, input().split())
    data = list(map(int, input().split()))
    answer = 0

    data.sort(reverse=True)  # 데이터 정렬하기
    mok = m / k  #
    namu = m % k #
    if(namu != 0):
        useNum = mok + 1
    else:
        useNum = mok

    for i in useNum:
        for j in range(k):
            answer += data[i]

    print(useNum)