import sys

numCases = int(input())
for i in range(numCases):
    numWalls = int(input())
    wallBeautyNum = input()
    beautyNumList = []
    for c in wallBeautyNum:
        beautyNumList.append(int(c));
    paintLen = (len(beautyNumList) + 1) // 2
    print("painted wall length: " + str(paintLen))
    maxBeautyScore = 0
    currSection = 0
    for j in range(paintLen):
        maxBeautyScore+=beautyNumList[j]
    print("max score atm: " + str(maxBeautyScore))
    currSection = maxBeautyScore
    start = 0
    end = paintLen
    while end < numWalls:
        print("end: " + str(end))
        currSection = currSection - beautyNumList[start] + beautyNumList[end]
        print("looking at max of: " + str(currSection))
        if currSection > maxBeautyScore:
            maxBeautyScore = currSection
        start+=1
        end+=1
    print("Case #" + str(i + 1) + ": " + str(maxBeautyScore))
