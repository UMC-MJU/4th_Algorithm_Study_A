# https://www.acmicpc.net/problem/1935

n = int(input())
word = input()                # 후위표기식을 word에 저장
num_lst = [0]*n				  # 피연산자값을 저장하기 위한 num_lst 생성

for i in range(n):
    num_lst[i] = int(input())  # 피연산자값 받기

stack = []                    # stack 리스트를 통해 후위표기식 계산

for i in word :
    if 'A' <= i <= 'Z' :		# 후위표기식에서 알파벳을 만나면 stack에 저장한다.(물론 알파벳 형태가 아닌 피연산자값의 형태로)
        # 여기서 ord()는 문자를 유니코드 정수값으로 바꿔주는 함수.
        stack.append(num_lst[ord(i)-ord('A')])
    # 연산자를 만나면
    else :
        str2 = stack.pop()		# stack 리스트의 마지막 2항목을 꺼내와서 계산
        str1 = stack.pop()

        if i =='+' :
            stack.append(str1+str2)
        elif i == '-' :
            stack.append(str1-str2)
        elif i == '*' :
            stack.append(str1*str2)
        elif i == '/' :
            stack.append(str1/str2)

print('%.2f' %stack[0])			# 소수점 자릿수를 제한