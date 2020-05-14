t = int(input())

for tc in range(1, t + 1):
    u = int(input())
    limit = 10 ** u + 1
    lst = [set() for _ in range(limit)]
    for _ in range(10000):
        q, r = input().split(' ')
        q = int(q)
        if q == -1:
            continue
        lst[q].add(r)

    answer = [None] * 10
    answer[1] = lst[1][0]
    for i in range(2, 11):
        s = lst[i]
        for j in range(i):
            if answer[j + 1] in s:
                s.remove(answer[j])
        if i == 10:
            answer[0] = s[0][1]
        else:
            answer[i] = lst[i][0]

        
    print('Case #' + str(tc) + ': ' + ''.join(answer))
