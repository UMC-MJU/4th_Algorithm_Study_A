# 유클리드 호제법
# 두 자연수 A, B에 대하여 A를 B로 나눈 나머지 R
# A와 B의 최대공약수는 B와 R의 최대공약수와 같다.

def gcd(a,b):
    if a % b ==0:
        return b
    else:
        return gcd(b, a % b)

print(gcd(192,162))