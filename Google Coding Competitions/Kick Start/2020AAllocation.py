import sys

numCases = int(input())
for i in range(numCases):
    n, b = list(map(int, input().split(' ')))
    houses = list(map(int, input().split(' ')))
    houses.sort()
    answer = 0
    for j in range(len(houses)):
        if b - houses[j] >= 0:
            answer += 1
            b -= houses[j]
    print("Case #" + str(i + 1) + ": " + str(answer))
