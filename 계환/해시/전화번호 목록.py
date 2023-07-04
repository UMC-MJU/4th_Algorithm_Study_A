def solution(phone_book):
    answer = True
    #find()함수 사용해서 포함여부, 시작 위치까지 알아내기
#     for i in range(len(phone_book)):
#         for j in range(i+1,len(phone_book)):
#             compare = phone_book[j].find(phone_book[i])
#             if compare == 0:
#                 answer = False
# 효율성 문제.. 이중루프 때문인듯
    phone_book.sort()
    for i in range(len(phone_book)-1):
        compare = phone_book[i+1].find(phone_book[i])
        if(compare == 0):
            answer = False
    return answer