n = input()
data = []
# 뛰기
for i in range(len(n)):
    for j in range(len(n)):
        if j+i <len(n):
            data.append(n[j:i+j+1])
print(len(set(data)))