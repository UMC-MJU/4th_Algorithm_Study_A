# n = input()


# -의 개수 찾기
# 그곳에서 먼저 계산 그리고 나머지






# mn = n.count("-")
# tmpmn = 0
# for i in range(len(n)):
#     if n[i] == "-":
#         tmpmn += 1
    

#     if tmpmn == mn:
        


# n = n.split("-")
# print(n)
# sum = int(n[0])

# mp = 0
# for i in range(1,len(n)):
#     t = n[i].split("+")

#     if len(t) >= 2:
#         for m in t:
#             mp += int(m)
        
#         sum -= mp
#     else:
#         sum -= int(t)

# print(sum)

arr = input().split('-')
print(arr[0])
s = 0
for i in arr[0].split('+'):
    s += int(i)
for i in arr[1:]:
    for j in i.split('+'):
        s -= int(j)
print(s)