t = int(input())

for tc in range(1, t + 1):
    n = int(input())
    c = list(map(int, input().split(' ')))
    peaks = 0
    prev = 0
    nxt = 2
    for i in range(1, len(c) - 1):
        if c[i] > c[prev] and c[i] > c[nxt]:
            peaks += 1
        prev += 1
        nxt += 1

    print('Case #' + str(tc) + ': ' + str(peaks))
