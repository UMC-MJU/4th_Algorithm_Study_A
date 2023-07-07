def solution(nums):
    # 뽑을 수 있는 폰켓몬 종류의 최댓값
    max = len(nums) / 2
    # 중복제거한 리스트의 원소개수
    special = len(set(nums))

    # 최댓값이 중복제거보다 크면 중복제거된 리스트 원소 개수 리턴, 중복제거가 더 크면 최댓값 리턴
    if max > special:
        return special
    else:
        return max
