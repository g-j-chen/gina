import math

maxN = 1000100

lfac = [0.0]
for i in range(1, maxN):
    lfac.append(lfac[i-1] + math.log(i))
p2 = [0, math.log(2)]
for i in range(2, maxN):
    p2.append(p2[i-1] + p2[1])


t = int(input())

def choose(n, k):
    if k < 0 or k > n:
        return 0
    return math.exp(lfac[n] - lfac[k] - lfac[n-k] - p2[n]);

for tc in range(1, t + 1):
    w, h, left, u, r, d = map(int, input().split(' '))
    w-=1
    h-=1
    left-=1
    u-=1
    r-=1
    d-=1
    """
    w = columns
    h = rows
    left = left
    u = up
    r = right
    d = down
    """
    
    answer = 0.0

    x, y = r, u
    if r < w:
        mult = 1.0
        while y > 0:
            y-=1
            x+=1
            if x >= w:
                x = w - 1
                mult = 0.5
            answer += mult * choose(x + y, x)

    u, left = left, u
    d, r = r, d
    h, w = w, h

    x, y = r, u
    if r < w:
        mult = 1.0
        while y > 0:
            y-=1
            x+=1
            if x >= w:
                x = w - 1
                mult = 0.5
            answer += mult * choose(x + y, x)

    answer = round(answer, 5)

    print('Case #' + str(tc) + ': ' + str(answer))
