# https://school.programmers.co.kr/learn/courses/30/parts/12077

def solution(phone_book):
    # 정렬 함수를 통해 만약 접두어 관계라면 바로 다음 index에 위치하도록
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) < len(phone_book[i + 1]):
            # startswith()함수는 문자열이 특정 문자열로 시작하는지 확인
            if phone_book[i+1].startswith(phone_book[i]):
                return False
    return True

#test
print(solution(["119", "97674223", "1195524421"]))