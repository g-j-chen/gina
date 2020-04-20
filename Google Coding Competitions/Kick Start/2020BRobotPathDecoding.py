t = int(input())

m = 1000000000

for tc in range(1, t + 1):
    d = input()

    diff_w = 0
    diff_h = 0
    mult = []
    for i in range(len(d)):
        c = d[i]
        if c.isdigit():
            c = int(c)
            if not mult:
                mult.append(c)
            else:
                c *= mult[-1]
                mult.append(c)
                continue

        if c == ')':
            mult.pop()
            continue

        if not mult:
            a = 1
        else:
            a = mult[-1]
            
        if c == 'N':
            diff_h -= a
        elif c == 'S':
            diff_h += a
        elif c == 'E':
            diff_w += a
        elif c == 'W':
            diff_w -= a

    w = (diff_w % m) + 1
    h = (diff_h % m) + 1

    print('Case #' + str(tc) + ':', w, h)
            
