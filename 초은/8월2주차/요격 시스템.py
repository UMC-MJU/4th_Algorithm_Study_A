# https://school.programmers.co.kr/learn/courses/30/lessons/181188

def solution(targets):
    answer = 0
    # e를 기준으로 정렬
    targets.sort(key=lambda x: x[1])

    e = 0

    for target in targets:
        # 타겟의 s(시작점)가 임시변수의 e(끝점)보다 크거나 같을 때
        if target[0] >= e:
            # 미사일 추가, 임시변수 끝점 업데이트
            answer += 1
            e = target[1]

    return answer

# 출력 예시
targets = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
print(solution(targets))