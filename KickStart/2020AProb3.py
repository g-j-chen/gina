import sys

numCases = int(input())
for i in range(numCases):
    n, k = list(map(int, input().split(' ')))
    wo = list(map(int, input().split(' ')))
    diff = []
    for j in range(1, n):
        diff.append(wo[j] - wo[j - 1])
    diff.sort()
    difSet = set(diff)
    d = diff[0]
    
    print(diff)
