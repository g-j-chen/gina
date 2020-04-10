import sys
from numpy import cumsum

beauty = []
cumulative = []
dp = []

def rec(stack, taken):
    if(taken == p):
        return 0
    if(stack > n or taken > p):
        return -1
    if(dp[stack][taken] != -1):
        return dp[stack][taken]

    ans = -1
    for i in range(k + 1):
        ans = max(ans, cumulative[stack][i] + rec(stack + 1, taken + i))
    dp[stack][taken] = ans
    return dp[stack][taken]

t = int(input())

for tc in range(1, t + 1):
    n, k, p = list(map(int, input().split(' ')))
    for i in range(n):
        b = map(int, input().split(' '))
        beauty.append(b)
        c = list(cumsum(b))
        cumulative.append(c)

    for _ in range(n + 1):
        a = [-1] * (k * (n + 1))
        dp.append(a)

    ans = rec(1, 0)
    print("Case #" + str(tc) + ": " + str(ans))



