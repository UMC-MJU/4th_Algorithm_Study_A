def solution(cards):
    n = len(cards)
    visited = [False] * (n + 1)
    rst = []
    # for i in range(1,n+1):
    #     data = []
    #     if visited[i] == False:
    #         # visited[i] = True
    #         data.append(i)
    #         tmp = i
    #         while True:
    #             if visited[tmp] == False:
    #                 tmp = data[tmp-1]
    #                 data.append(tmp)
    #                 visited[tmp] = True
    #             else:
    #                 rst.append(data)
    #                 break
    # while cards:
    rst = []
    for i in range(1, n + 1):
        data = []
        if visited[i] == False:
            data.append(i)
            visited[i] = True
            tmp = i

            while True:
                tmp = cards[tmp - 1]

                if visited[tmp] == False:
                    data.append(tmp)
                    visited[tmp] = True
                else:
                    rst.append(data)
                    break
    answer = []
    for i in rst:
        answer.append(len(i))
    # print(answer)
    answer.sort(reverse=True)
    if answer[0] == n: # 이 예외문을 생각치 못했다;;
        return 0
    else:
        return answer[0] * answer[1]
