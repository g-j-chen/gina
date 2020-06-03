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

def lengthToCycle(b):
    if b.count("1") == 2:
        return
    
    global tableOutput
    numSeen = {b : 0}
    i = 1
    num = b
    length = 0
    period = 0
    while int(b, 2) != 0:
        b = getNextTuple(b)
        if b.count("1") == 2 and length == 0:
            length = i;
        if b in tableOutput and length > 0:
            print(b, tableOutput[b], length)
        if b in numSeen:
            start = numSeen.get(b)
            period = i - start
            length = start
            break
        else:
            numSeen[b] = i
        i+=1
    if int(b, 2) == 0:
        return [num, 0, 0, i - 1]
    return [num, length, period, 0]

def main():
    print("Enter the length range (inclusive) of desired tuples:")
    s, m = map(int, input().split(" "))
    #f = open("DucciData.txt", "w+")
    for p in range(s, m + 1):
        global tableOutput
        tableOutput = {}
        meanVarOutput = []
        lenValues = []
        periodValues = []
        vanish = []
        inCycleCount = 0

        for n in range(1, 2 ** p):
            b = "{0:b}".format(n).zfill(p)
            print(b)
            res = lengthToCycle(b)
            
            if res != None:
                tableOutput[res[0]] = (res[1], res[2], res[3])
                if res[2] != 0:
                    lenValues.append(res[1])
                    periodValues.append(res[2])
                elif res[3] != 0:
                    vanish.append(res[3])
            else:
                inCycleCount+=1

        """
        f.write("Tuple length: " + str(p) + "\n")
        f.write(str(inCycleCount) + " tuples already in a cycle\n")
        headers = ["Tuple", "Length to cycle", "Period", "Iterations to vanish"]
        f.write(tabulate([(k, ) + v for k, v in tableOutput.items()], headers, tablefmt="pretty") + "\n")

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
    """
        


    
if __name__ == "__main__":
    main()
