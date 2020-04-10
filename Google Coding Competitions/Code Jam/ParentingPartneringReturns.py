t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    s = []
    for i in range(n):
        a = list(map(int, input().split(' ')))
        a.append(i)
        s.append(a)

    array = []
    answer = ''
    possible = True
    
    s.sort()

    C = [False, 0]
    J = [False, 0]

    for i in range(n):
        if C[0] and C[1] <= s[i][0]:
            C[0] = False
        if J[0] and J[1] <= s[i][0]:
            J[0] = False
            
        if C[0] and J[0]:
            answer = 'IMPOSSIBLE'
            possible = False
            break;
        
        if C[0]:
            J[0] = True
            J[1] = s[i][1]
            array.append((s[i][2], 'J'))
        else:
            C[0] = True
            C[1] = s[i][1]
            array.append((s[i][2], 'C'))

    if possible:
        array.sort()

        for i in range(n):
            answer += array[i][1]

    print("Case #" + str(tc) + ": " + answer)
