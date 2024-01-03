s = input()
while s != ".":

    data = []
    for i in s:
        if i == "(":
            data.append("(")
        elif i == ")":
            if data == []:
                print("no")
                break
            if data[-1] == "(":
                data.pop()
            else:
                print("no")
                break
        elif i == "[":
            data.append("[")
        elif i == "]":
            if data == []:
                print("no")
                break
            if data[-1] == "[":
                data.pop()
            else:
                print("no")
                break
    else:
        # data 값이 ([인 경우
        if data != []:
            print("no")
        else:
            print("yes")
    s = input()