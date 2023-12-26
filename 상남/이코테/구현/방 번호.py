# n = int(input())
# data = {
#     0 : 0,
#     1 : 0,
#     2 : 0,
#     3 : 0,
#     4 : 0,
#     5 : 0,
#     6 : 0,
#     7 : 0,
#     8 : 0,
#     9 : 0
# }
#
#
# for i in str(n):
#     if i == "6" or i == "9":
#         continue
#     data[int(i)] += 1
#
# cs = (str(n).count("6"))
# cn = (str(n).count("9"))
#
# sum = cs + cn
# rst = 0
# if sum % 2 == 0:
#     rst = sum // 2
# else:
#     rst += 1
#
# m = 0
# for value in data.values():
#
#     if m < value:
#         m = value
# # print(rst,m)
# if rst > m:
#     print(rst)
# else:
#     print(m)


n = int(input())
data = {
    0 : 0,
    1 : 0,
    2 : 0,
    3 : 0,
    4 : 0,
    5 : 0,
    6 : 0,
    7 : 0,
    8 : 0,
    9 : 0
}


for i in str(n):
    if i == "6" or i == "9":
        if data[6] > data[9]:
            data[9] += 1
        else:
            data[6] += 1
    else:
        data[int(i)] += 1

tmp = 0
for value in data.values():
    if value > tmp:
        tmp = value
print(tmp)


