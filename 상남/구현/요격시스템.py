def solution(targets):
    targets.sort(key = lambda x : (x[1],x[0])) # e를 기준으로 오름차순으로 정렬하돼 e값이 같다면 x[0]을 기준으로 오름차순 ex -> [1,3][1,2] ==> [1,2][1,3]
    cnt = 0
    e = 0
    for target in targets: 
        if target[0] >= e: # 이전 미사일 e보다 크다면
            cnt += 1
            e = target[1] # e 좌표 업그레이드
    return cnt