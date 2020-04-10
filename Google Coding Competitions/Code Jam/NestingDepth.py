t = int(input())
for tc in range(1, t + 1):
    s = [int(x) for x in input()]
    answer = ''

    p = 0
    for i in range(len(s)):
        diff = s[i] - p
        if diff > 0:
            answer += ('(' * diff)
            p += diff
        elif diff < 0:
            answer += (')' * abs(diff))
            p += diff
        answer += str(s[i])
    if p > 0:
        answer += (')' * p)

    print("Case #" + str(tc) + ": " + answer)
    
