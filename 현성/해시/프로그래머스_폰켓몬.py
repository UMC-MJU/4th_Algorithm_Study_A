def solution(nums):
    num_types = len(set(nums))
    max_count = len(nums) // 2
    return min(num_types, max_count)
