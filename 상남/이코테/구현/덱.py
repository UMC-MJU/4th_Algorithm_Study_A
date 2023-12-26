n = int(input())
data = [list(input().split()) for _ in range(n)]
rst = []
for i in data:
    if i[0] == "push_front":
        rst.insert(0,i[1])
    elif i[0] == "push_back":
        rst.append(i[1])
    elif i[0] == "pop_front":
        if len(rst) == 0:
            print(-1)
        else:
            print(rst.pop(0))
    elif i[0] == "pop_back":
        if len(rst) == 0:
            print(-1)
        else:
            print(rst.pop())
    elif i[0] == "size":
        print(len(rst))
    elif i[0] == "empty":
        if len(rst) == 0:
            print(1)
        else:
            print(0)
    elif i[0] == "front":
        if len(rst) == 0:
            print(-1)
        else:
            print(rst[0])
    elif i[0] == "back":
        if len(rst) == 0:
            print(-1)
        else:
            print(rst[-1])
