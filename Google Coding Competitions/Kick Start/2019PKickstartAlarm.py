import sys

def calcX(c, x, d, y, e, f):
    return (c * x + d * y + e) % f

def calcY(d, x, c, y, e, f):
    return (d * x + c * y + e) % f

def calcElement(x, y, f):
    return (x + y) % f

def getAllContiguousSubarr(arr, n):
    subArr = []
    for i in range(n):
        for j in range(i, n):
            temp = []
            for k in range(i, j + 1):
                temp.append(arr[k])
            subArr.append(temp)
    return subArr

numCases = int(input())
for i in range(numCases):
    caseInput = input()
    n, k, x1, y1, c, d, e1, e2, f = list(map(int, caseInput.split(' ')))
    xArr = []
    yArr = []
    xArr.append(x1)
    yArr.append(y1)
    pArr = []
    pArr.append(calcElement(x1, y1, f))
    for j in range(1, n):
        tempX = calcX(c, xArr[j - 1], d, yArr[j - 1], e1, f)
        xArr.append(tempX)
        tempY = calcY(d, xArr[j - 1], c, yArr[j - 1], e2, f)
        yArr.append(tempY)
        pArr.append(calcElement(tempX, tempY, f))
    allSubArr = getAllContiguousSubarr(pArr, n)
    for list in allSubArr:
        powerSum = 0
    for p in range(k):
        pwr = p + 1
        for list in allSubArr:
            for num in range(len(list)):
                mult = num + 1
                powerSum += list[num] * (mult ** pwr)
    
    print("Case #" + str(i + 1) + ": " + str(powerSum % 1000000007))
                

