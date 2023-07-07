# https://school.programmers.co.kr/learn/courses/30/lessons/1845

def solution(nums):
    count = int(len(nums)/2)
    #리스트 중복 제거
    nums = set(nums) #set은 중복을 허용하지 않는 자료형태
    nums = list(nums)

    #중복을 제거한 list의 값들이 nums/2보다 많을 때
    if(len(nums) > count) :
        return count
    #중복 제거한 list의 값들이 num/2보다 적을 때
    else :
        return len(nums)