from collections import Counter

t = int(input())

for tc in range(1, t + 1):
    n, d = map(int, input().split(' '))
    angle = list(map(int, input().split(' ')))

    c = Counter()
    for i in angle:
        c[i] += 1
    
    if d in c.values():
        print('Case #' + str(tc) + ': 0')
        continue
         
    if d == 2:
        print('Case #' + str(tc) + ': 1')
        continue

    found = 0
    if d == 3:
        angle.sort()
        for j in angle:
            if (j * 2) in c:
                print('Case #' + str(tc) + ': 1')
                found = 1
                break
    
    if found == 0:
        print('Case #' + str(tc) + ': 2')
