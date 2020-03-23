import sys

def recalc(stacks):
    cumulative = []
    ave = []
    for list in stacks:
        ctemp = []
        atemp = []
        val = 0
        for j in range(len(list)):
            val += list[j]
            ctemp.append(val)
            atemp.append((j + 1, val//(j + 1)))
        cumulative.append(ctemp)
        ave.append(atemp)
    return (cumulative, ave)

def getLargestTuple(ave, numPlates):
    maxVal = 0
    li = -1
    num = 0
    for i in range(len(ave)):
        if ave[i][0][0] <= numPlates:
            if ave[i][0][1] > maxVal:
                li = i
                num = ave[i][0][0]
                val = maxVal = ave[i][0][1]
    return (li, num, val)

numCases = int(input())

for i in range(numCases):
    n, k, p = list(map(int, input().split(' ')))
    stacks = []
    for j in range(n):
        temp = list(map(int, input().split(' ')))
        stacks.append(temp)
    cumulative = []
    ave = []
    for list in stacks:
        ctemp = []
        atemp = []
        val = 0
        for j in range(len(list)):
            val += list[j]
            ctemp.append(val)
            atemp.append((j + 1, val//(j + 1)))
        cumulative.append(ctemp)
        ave.append(atemp)
    for list in cumulative:
        print(list)
    for list in ave:
        list.sort(key=lambda x: x[1], reverse=True)
        print(list)

    currPlates = 0
    plateTuples = [0] * n
    #while currPlates < p:
    li, num, val = getLargestTuple(ave, p - currPlates)
    print(li, num, val)
    for j in range(num):
        stacks[li].pop(0)

    cumulative, ave = recalc(stacks)
    for list in cumulative:
        print(list)
    for list in ave:
        print(list)
            
    
