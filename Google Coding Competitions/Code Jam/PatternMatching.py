t = int(input())
    
def comparePatterns(a, b):
    i = len(a) - 1
    j = len(b) - 1
    while i >= 0 or j >= 0:
        if a[i] == b[j]:
            i -= 1
            j -= 1
            continue
        if a[i] == '*':
            return True
        elif a[i] != b[j]:
            return False
        

for tc in range(1, t + 1):
    n = int(input())
    s = set()
    for _ in range(n):
        s.add(input())
    answer = ""
    patterns = list(s)
    patterns.sort(key = lambda s: len(s))
    longest = patterns[-1]
    match = True
    for i in range(len(patterns) - 1):
        match = comparePatterns(patterns[i], longest)
        if match == False:
            break

    if match == False:
        answer = '*'
    else:
        answer = longest[1:]        
        
    print("Case #" + str(tc) + ": " + answer)
