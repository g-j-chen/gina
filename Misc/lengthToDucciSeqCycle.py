import statistics

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
    if bin(n).count("1") == 2:
        print(n, "is already in a cycle - exiting");
        return

    print("Starting interations")
    numSeen = {n: 0}
    i = 1
    length = 0
    period = 0
    print(b)
    while n != 0:
        b = getNextTuple(b.zfill(p))
        print(b)
        n = int(b, 2)
        if n in numSeen:
            start = numSeen.get(n)
            period = i - start
            length = start
            print("period of cycle is", period)
            print("length to start of cycle is", length)
            break
        else:
            numSeen[n] = i
        i+=1
    return length, period

def main():
    print("Enter the maximum length of tuples desired:")
    m = int(input())
    lenArr = []
    periodArr = []
    for p in range(3, m + 1):
        lenValues = []
        periodValues = []
        for n in range(1, 2 ** p):
            b = "{0:b}".format(n).zfill(p)
            info = lengthToCycle(b, p)
            print(info)
            if info != None:
                lenValues.append(info[0])
                periodValues.append(info[1])
        print("        Mean     Variance")
        print("Length:", statistics.mean(lenValues), "     ", statistics.variance(lenValues))
        print("Period:", statistics.mean(periodValues), "     ", statistics.variance(periodValues))
        lenArr.append(lenValues)
        periodArr.append(periodValues)

    print("length array:", lenArr)
    print("period array:", periodArr)

    
if __name__ == "__main__":
    main()
