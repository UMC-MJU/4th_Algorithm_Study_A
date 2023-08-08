def solution(today, terms, privacies):
    today = today.split(".")    # today를 .으로 구분
    result = []
    data={} 
    
    for term in terms:
        term = term.split(" ")  # term을 빈칸으로 구분
        data[term[0]] = int(term[1]) # 해쉬로 A ->6이 나오게 만듬

    
    
    for idx,privace in enumerate(privacies):
        privace = privace.split(".")    # privace를 .으로 구분
        tmp = privace[2].split(" ") # privace를 .으로 구분한 두번째 변수를 빈칸으로 구분 (term을 구하기 위해)
        
        
        if int(tmp[0]) == 1:    # 1일이면 28일까지가 유효기간이므로 28일로 설정하고 달도 1달 빼준다
            privace[1] = int(privace[1]) + data[tmp[1]] - 1
            privace[2] = 28
        else:
            privace[1] = int(privace[1]) + data[tmp[1]]
            privace[2] = int(tmp[0]) - 1
        
        if privace[1] > 12: # 달이 12월이 넘으면 12월이하가 될 때까지 12월씩 빼주고 1년씩 더해줌
            while privace[1] > 12:
                privace[1] = privace[1] - 12
                privace[0] = int(privace[0]) + 1
        else:
            privace[0] = int(privace[0])
        
        
            
        if int(today[0]) > privace[0]: # 년만 비교한 후 오늘년도가 더 크면 유효기간이 지난거므로 폐기
            result.append(idx+1)
        elif int(today[1]) > privace[1] and int(today[0]) == privace[0]:    # 년이 같으면서 오늘 월이 더 크면 유효기간이 지난거므로 폐기
            result.append(idx+1)
        elif int(today[2]) > privace[2] and int(today[1]) == privace[1] and int(today[0]) == privace[0]:    # 년이 같으면서 월도 같으면서 오늘 일이 더 크면 유효기간이 지난거므로 폐기
            result.append(idx+1)
    return result
        
    