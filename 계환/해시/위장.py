def solution(clothes):

    #종류끼리 분류하고 하나씩 선택하기 - 하나도 선택하지 않은 경우 빼기
    #종류 몇개인지 파악하기

    data = dict()
    for i in range(len(clothes)):
        data[clothes[i][0]] = clothes[i][1]
    kindList = set(list(data.values()))

    result = 1
    count = 0
    print(kindList)
    for kind in kindList:
        count = 0
        for i in range(len(clothes)):
            if kind == clothes[i][1]:
                count += 1
        print(count)
        result *= (count+1)

    return result-1