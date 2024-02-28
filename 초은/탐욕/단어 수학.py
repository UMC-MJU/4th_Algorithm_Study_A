# https://www.acmicpc.net/problem/1339

import sys

n = int(sys.stdin.readline())

al_dict = {'A': 0, 'B': 0, 'C': 0, 'D': 0, 'E': 0, 'F': 0, 'G': 0, 'H': 0, 'I': 0, 'J': 0, 'K': 0, 'L': 0, 'M': 0, 'N': 0, 'O': 0, 'P': 0, 'Q': 0, 'R': 0, 'S': 0, 'T': 0, 'U': 0, 'V': 0, 'W': 0, 'X': 0, 'Y': 0, 'Z': 0}
al_list = []
answer = 0
pocket = []

for _ in range(n):
    alphabet = input()
    pocket.append(alphabet)

for alphabet in pocket:
    for i in range(len(alphabet)):
        num = 10 ** (len(alphabet) - i - 1)
        al_dict[alphabet[i]] += num

for value in al_dict.values():
    if value > 0:
        al_list.append(value)

sorted_list = sorted(al_list, reverse=True)
for i in range(len(sorted_list)):
    answer += sorted_list[i] * (9 - i)

print(answer)
