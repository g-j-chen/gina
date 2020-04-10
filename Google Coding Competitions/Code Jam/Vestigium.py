t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    matrix = []
    k = 0
    r = 0
    c = 0
    ln = 0;
    columnsAsRows = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        row = list(map(int, input().split(' ')))
        k += row[i]
        matrix.append(row)
        
        for j in range(n):
            columnsAsRows[j][ln] = row[j]
        ln += 1

        setOfRow = set(row)
        if len(setOfRow) != n:
            r += 1
        
    for i in range(n):
        setOfCol = set(columnsAsRows[i])
        if len(setOfCol) != n:
            c += 1
    

    print("Case #" + str(tc) + ":", str(k), str(r), str(c))
