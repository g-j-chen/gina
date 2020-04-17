import math

t = int(input())

global walk
global curr_n

def getPossibleNextCell(pos):
    possibleCells = []
    r = pos[0]
    k = pos[1]
    if r - 1 > 1:
        if k - 1 > 1:
            possibleCells.append((r - 1, k - 1))
        possibleCells.append((r - 1, k))
    if k - 1 > 1:
        possibleCells.append((r, k - 1))
    if k + 1 <= r:
        possibleCells.append((r, k + 1))
    possibleCells.append((r + 1, k))
    possibleCells.append((r + 1, k + 1))
    pascalNums = []
    for cell in possibleCells:
        if cell in walk:
            possibleCells.remove(cell)
        num = int(getPascalNum(cell))
        pascalNums.append(num)
    index, maxNum = -1, -1
    for i in range(len(pascalNums)):
        if pascalNums[i] <= curr_n:
            temp = pascalNums[i]
            if temp > maxNum:
                maxNum = temp
                index = i
    return (possibleCells[index], maxNum)
        

def getPascalNum(pos):
    r = pos[0] - 1
    k = pos[1] - 1
    return math.factorial(r) / (math.factorial(k) * math.factorial(r - k))

for tc in range(1, t + 1):
    n = int(input())
    curr_n = n - 1
    curr_pos = (1, 1)
    walk = {curr_pos}
    path = [curr_pos]
    while curr_n > 0:
        r = getPossibleNextCell(curr_pos)
        new_pos = r[0]
        walk.add(new_pos)
        path.append(new_pos)
        p_num = r[1]
        curr_n -= p_num
        curr_pos = new_pos

    print("Case #" + str(tc) + ":")
    for i in range(len(path)):
        print(path[i])
