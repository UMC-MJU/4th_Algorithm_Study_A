# https://school.programmers.co.kr/learn/courses/30/lessons/87946
from itertools import permutations

def solution(k, dungeons):
    answer = 0

    dun_len = len(dungeons)

    for permute in permutations(dungeons, dun_len):
        hp = k
        count = 0

        for pm in permute:
            if hp >= pm[0]:
                hp -= pm[1]
                count += 1

            if count > answer:
                answer = count

    return answer
