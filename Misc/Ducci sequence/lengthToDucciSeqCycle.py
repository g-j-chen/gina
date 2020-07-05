import statistics
from tabulate import tabulate

def getNextTuple(b):
    s = []
    for i in range(len(b) - 1):
        if b[i] == b[i+1]:
            s.append('0')
        else:
            s.append('1')
    if b[-1] == b[0]:
        s.append('0')
    else:
        s.append('1')
    return ''.join(s)

def lengthToCycle(b): #b is in string format
    numSeen = {b : 0}
    i = 1
    num = b #to store the starting tuple
    length = 0
    period = 0
    toZero = 0
    bAsInt = int(b, 2)

    global data
    if data[bAsInt] is not None:
        #print("tuple seen previously:", b)
        storedData = data[bAsInt]
        if storedData[1] == 0:
            toZero = storedData[2]
        else:
            length = storedData[0]
            period = storedData[1]
        return [num, length, period, toZero]
            
    tuplesList = [bAsInt] #store the tuples (as integers) in order
    
    while bAsInt != 0:
        b = getNextTuple(b)
        bAsInt = int(b, 2)
        if data[bAsInt] is not None:
            #print("tuple seen previously:", b)
            storedData = data[bAsInt]
            if storedData[1] == 0:
                toZero = storedData[2] + i
            else:
                length = storedData[0] + i
                period = storedData[1]
            break
        if b in numSeen:
            #print("detected cycle")
            start = numSeen.get(b)
            period = i - start
            length = start
            break
        numSeen[b] = i
        tuplesList.append(bAsInt)
        i+=1
            
    if bAsInt == 0:
        toZero = i - 1

    #print("tuplesList:")
    #print(tuplesList)
    #iterate through tuplesList and set each tuple (as integers)'s (length to cycle, period, interations to zero) in data
    for j in range(len(tuplesList)):
        dataInd = tuplesList[j]
        if data[dataInd] is None:
            #print("Adding", tuplesList[j], "to data list")
            if toZero != 0:
                #print("vanishes after", str(toZero - j), "iterations")
                data[dataInd] = (0, 0, toZero - j)
            else:
                jLength = max(length - j, 0)
                #print("length =", jLength, "period =", period)
                data[dataInd] = (jLength, period, 0)


    return [num, length, period, toZero]

def main():
    print("Enter the length range (inclusive) of desired tuples separated by a space (eg 4 10):")
    s, m = map(int, input().split(" "))
    f = open("DucciData.txt", "w+")
    for p in range(s, m + 1):
        tableOutput = {}
        meanVarOutput = []
        lenValues = []
        periodValues = []
        vanish = []
        inCycleCount = 0

        global data
        data = [None] * 2 ** p

        for n in range(1, 2 ** p):
            b = "{0:b}".format(n).zfill(p)
            #print(b)
            res = lengthToCycle(b)
            tableOutput[res[0]] = (res[1], res[2], res[3])
            if res[2] != 0:
                lenValues.append(res[1])
                periodValues.append(res[2])
            elif res[3] != 0:
                vanish.append(res[3])

        f.write("Tuple length: " + str(p) + "\n")

        #This will print out all tuples not already in a cycle and their length to cycles, period, etc
        #The file will get pretty long as n increases, use at your own discretion
        """
        headers = ["Tuple", "Length to cycle", "Period", "Iterations to vanish"]
        f.write(tabulate([(k, ) + v for k, v in tableOutput.items()], headers, tablefmt="pretty") + "\n")
        """


        headers = ["      ", "Mean", "Variance"]
        lenMean = statistics.mean(lenValues) if len(lenValues) > 0 else 0
        lenVar = statistics.variance(lenValues) if len(lenValues) > 1 else 0
        periodMean = statistics.mean(periodValues) if len(periodValues) > 0 else 0
        periodVar = statistics.variance(periodValues) if len(periodValues) > 1 else 0
        vanishMean = statistics.mean(vanish) if len(vanish) > 0 else 0
        vanishVar = statistics.variance(vanish) if len(vanish) > 1 else 0
        f.write(tabulate([["Length", lenMean, lenVar],
                        ["Period", periodMean, periodVar],
                        ["Vanish", vanishMean, vanishVar]],
                       headers, tablefmt="pretty") + "\n\n")

    f.close()
        


    
if __name__ == "__main__":
    main()
