import sys

t = int(input())

for tc in range(1, t + 1):
    n, k, p = list(map(int, input().split(' ')))

    sumPlates = [[0 for _ in range(k + 1)]]
    for _ in range(n):
        stack = list(map(int, input().split(' ')))
        stack.insert(0, 0)
        s = 0
        for a in range(k + 1):
            s += stack[a]
            stack[a] = s
        sumPlates.append(stack)
    
    dp = [[0 for i in range(p + 1)] for j in range(n + 1)]

    for i in range(1, n + 1):
        for j in range(1, p + 1):
            for x in range(min(j, k) + 1):
                dp[i][j] = max(dp[i][j], sumPlates[i][x] + dp[i - 1][j - x])
        
    print("Case #" + str(tc) + ": " + str(dp[n][p]))



