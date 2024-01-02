# https://www.acmicpc.net/problem/1475

from collections import Counter

N = list(map(int, input()))
count_dict = Counter(N)

# 9와 6은 바꿔서 쓸 수 있으니까 같이 세기
count_dict[6] = (count_dict[6] + count_dict[9] + 1) // 2
if 9 in count_dict:
    count_dict.pop(9)

# 최댓값 가진 key
max_key = max(count_dict, key=count_dict.get)

print(count_dict[max_key])
