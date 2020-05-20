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

def lengthToCycle(n):
    if bin(n).count("1") == 2:
        print(n, "is already in a cycle - exiting");
        return;

    b = "{0:b}".format(n)
    z = len(b)
    numSeen = {n: 0}
    i = 1
    print(b)
    while n != 0:
        b = getNextTuple(b.zfill(z))
        print(b)
        n = int(b, 2)
        if n in numSeen:
            start = numSeen.get(n)
            period = i - start
            print("period of cycle is", period)
            print("length to start of cycle is", start)
            break
        else:
            numSeen[n] = i
        i+=1


print("Enter a number:")
n = int(input())
lengthToCycle(n)
