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

def lengthToCycle(b, p):
    n = int(b, 2)
    numSeen = {n: 0}
    i = 1
    num = b
    length = 0
    period = 0
    toZero = 0
    while n != 0:
        b = getNextTuple(b.zfill(p))
        toZero+=1
        n = int(b, 2)
        if n in numSeen:
            start = numSeen.get(n)
            period = i - start
            length = start
            break
        else:
            numSeen[n] = i
        i+=1
    if n == 0:
        return [num, 0, 0, toZero]
    return [num, length, period, 0]

def main():
    print("Enter the length range (inclusive) of desired tuples:")
    s, m = map(int, input().split(" "))
    f = open("DucciControlData.txt", "w+")
    for p in range(s, m + 1):
        tableOutput = []
        meanVarOutput = []
        lenValues = []
        periodValues = []
        vanish = []
        for n in range(1, 2 ** p):
            b = "{0:b}".format(n).zfill(p)
            res = lengthToCycle(b, p)
            tableOutput.append(res)
            if res[2] != 0:
                lenValues.append(res[1])
                periodValues.append(res[2])
            elif res[3] != 0:
                vanish.append(res[3])

        f.write("Tuple length: " + str(p) + "\n")
        headers = ["Tuple", "Length to cycle", "Period", "Iterations to vanish"]
        f.write(tabulate(tableOutput, headers, tablefmt="pretty") + "\n")

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
