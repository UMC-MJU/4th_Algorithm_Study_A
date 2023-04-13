# https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=python3

import collections
def solution(participant, completion):
    dictionary = {}
    # participant 리스트를 개수를 포함한 딕셔너리로 변환하는 collection 모듈
    dictionary = collections.Counter(participant)

    #그냥 remove()를 하면 중복값들이 한번에 지워지기 때문에 dictionary로 바꾸어서 실행
    for x in completion :
        # 2명 이상 존재할 때 value - 1
        if dictionary[x] > 1:
            dictionary[x] = dictionary[x]-1
        # 1명밖에 없을 때 key 값 삭제
        else:
            del(dictionary[x])
    # 괄호 없이 출력하기 위해 join() 함수 사용
    return (','.join(dictionary.keys()))