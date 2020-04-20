t = int(input())

for tc in range(1, t + 1):
    n, d = map(int, input().split(' '))
    b = list(map(int, input(). split(' ')))

    day = d

    for i in range(len(b) - 1, -1, -1):
        div = day // b[i]
        day = b[i] * div
    
    print('Case #' + str(tc) + ': ' + str(day))
