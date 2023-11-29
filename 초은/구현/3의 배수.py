# https://www.acmicpc.net/problem/1769

string = input()
count = 0

while len(string) > 1:
    num_list = [int(i) for i in str(string)]
    string = str(sum(num_list))
    count += 1

print(count)

# 나머지가 0이면 가능, 아니면 불가능
if int(string) % 3 == 0:
    print("YES")
else:
    print("NO")

