import sys
global n
global k
global w

def isValid(d):
    req = 0
    for i in range(n - 1):
        req += (w[i + 1] - w[i] - 1) // d
    if req <= k:
        return True
    return False

def binarySearch(low, high):
    while low < high:
        mid = (low + high) // 2
        if isValid(mid):
            high = mid
        else:
            low = mid + 1
    return low

t = int(input())
for tc in range(1, t + 1):
    n, k = map(int, input().split(' '))
    w = list(map(int, input().split(' ')))
    ans = binarySearch(1, 10 ** 9)
    
    print("Case #" + str(tc) + ": " + str(ans))
