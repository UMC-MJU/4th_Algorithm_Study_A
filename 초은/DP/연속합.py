# https://www.acmicpc.net/problem/1912

N = int(input())
result = [0]*(N)     #최댓값 후보를 저장할 배열, 덧셈을 멈출 경우 다시 0부터 더해야 하므로 크기가 N인 0 배열
graph = list(map(int, input().split()))

result[0] = graph[0]
for i in range(1, N) :
    #오른쪽으로 합을 구하면서 더해나가다가, 더하기 전 vs 더한 후 했을 때 더하기 전이 더 크다면 덧셈을 더 할 필요가 X
    #더하기 전이 크다면 덧셈을 멈추고 0부터 다시 오른쪽 방향으로 합 비교 시작

    result[i] = max(graph[i], graph[i] + result[i-1])
print(max(result))