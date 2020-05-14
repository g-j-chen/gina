t = int(input())

for tc in range(1, t + 1):
    x, y, m = input().split(' ')
    x = int(x)
    y = int(y)
    tx, ty = x, y
    limit = 0
    answer = 0
    for c in m:
        if c == 'N':
            ty += 1
        elif c == 'S':
            ty -= 1
        elif c == 'E':
            tx += 1
        elif c == 'W':
            tx -= 1
        limit += 1
        if abs(tx) + abs(ty) <= limit:
            answer = limit
            break


    if answer == 0:
        print('Case #' + str(tc) + ': ' + 'IMPOSSIBLE')
    else:
        print('Case #' + str(tc) + ': ' + str(answer))
    

    
