def solution(new_id):
    new_id = new_id.lower() #1
    new_data2 = []
    
    for word in new_id: #2
        if word >="a" and word <="z" or word>="0"and word<="9" or word =="-" or word == "_" or word == ".":
            new_data2.append(word)
    
    new_data3 = [] # new_data2를 활용하면서 new_data3에 추가
    for i in range(len(new_data2)): #3
        if new_data2[i] == ".": #해당 인덱스가 .이면서
            if new_data2[i-1] == ".": # 전에것도 .이면 넘어간다.
                continue
            else:
                new_data3.append(new_data2[i]) # 단독으로 .이면 추가한다.    
        else:
            new_data3.append(new_data2[i]) #.이 아닌 나머지 데이터는 추가
    
    if new_data3 == []: #5 
        new_data3.append("a") # 빈리스트면 a 추가
        
    if new_data3[0] == ".": #4
        new_data3.pop(0) # 처음이 .이면 삭제
    if new_data3[-1] == ".":        
        new_data3.pop() # 마지막이 .이면 삭제
        
    if len(new_data3) >= 16: #6
        new_data3 = new_data3[:15] # 16자 이상이면 15자까지로 슬라이싱
        if new_data3[-1] ==".": # 근데 마지막이 .이면 마지막. 삭제
            new_data3.pop()
    
    if len(new_data3) <= 2: #7
        while len(new_data3) !=3: # 3글자가 될때까지 마지막 글자 추가
            new_data3.append(new_data3[-1])
    
    return "".join(new_data3) # 리스트를 문자열로 합치기
    
    
                
    

# print(solution("...!@BaT#*..y.abcdefghijklm"))
# print(solution("z-+.^."))
# print(solution("=.="))
# print(solution("123_.def"))
# print(solution("abcdefghijklmn.p"))