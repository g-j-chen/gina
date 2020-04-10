t, b = map(int, input().split(' '))

global query
global identical_check
global diff_check
global array
    
query = 0
array = [-1] * (b + 1)
identical_check = [-1, -1]
diff_check = [-1, -1]


def findPairs():
    p = 1
    p_comp = b
    qry = 0
    
    while(p < p_comp):
        print(p)
        r = input()
        if r == 'N':
            return True
        r = int(r)

        print(p_comp)
        r_comp = input()
        if r_comp == 'N':
            return True
        r_comp = int(r_comp)
        
        if r == r_comp and identical_check[0] == -1:
            identical_check[0] = p
            identical_check[1] = r
        elif r != r_comp and diff_check[0] == -1:
            diff_check[0] = p
            diff_check[1] = r

        qry += 2

        if identical_check[0] != -1 and diff_check[0] != -1:
            break
        
        p += 1
        p_comp -= 1

    return qry
        

def changeArray(operation):
    start = 1
    end = b
    if operation == 'swap':
        while start <= end:
            if array[start] != -1:
                array[start], array[end] = array[end], array[start]
            start += 1
            end -= 1
    elif operation == 'compliment':
        for i in range(len(array)):
            if array[i] == 0:
                array[i] = 1
            elif array[i] == 1:
                array[i] = 0
    else:
        while start <= end:
            if array[start] != -1:
                array[start], array[end] = array[end], array[start]
                array[start] = 1 if array[start] == 0 else 1
                array[end] = 1 if array[end] == 0 else 1
            start += 1
            end -= 1
    

for i in range(t):   
    query = findPairs()
    if query == True:
        break

    p = 1
    p_comp = b

    while query <= 150:
        print(p)
        r = input()
        if r == 'N':
            break
        r = int(r)
        
        query += 1

        if query % 10 == 1:
            if identical_check[0]!= -1 and diff_check[0] != -1:
                print(identical_check[0])
                r1 = int(input())
                print(diff_check[0])
                r2 = int(input())
                if r1 == identical_check[1]:
                    if r2 != diff_check[1]:
                        changeArray('swap')
                else:
                    if r2 == diff_check[1]:
                        changeArray('both')
                    else:
                        changeArray('compliment')
                query += 2

        else:
            array[p] = r

        p += 1
        p_comp -= 1

    answer = array[1:]
    print(''.join(answer))
    r = input()
    if r == 'N':
        break
    
