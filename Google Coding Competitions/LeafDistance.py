k = int(input())
n = int(input())
if n == -1:
    print(-1)
    sys.exit()

global tree
global length
global answer

def getParent(pos):
    p = (pos - 1) // 2
    return p if tree[p] > 0 else -1

def getChildren(pos):
    lc = pos * 2 + 1
    rc = pos * 2 + 2
    if lc >= length or tree[lc] == -1:
        lc = -1
    if rc >= length or tree[rc] == -1:
        rc = -1
    return lc, rc

def kStep(k, node, visited):
    global answer
    if k < 0:
        return
    visited[node] = node
    lc, rc = getChildren(node)
    if lc == -1 and rc == -1:
        if started[node] == -1:
            answer += 1
            
    p = getParent(node)

    if lc != -1 and visited[lc] == -1:
        kStep(k - 1, lc, visited)
    if rc != -1 and visited[rc] == -1:
        kStep(k - 1, rc, visited)
    if p != -1 and visited[p] == -1:
        kStep(k - 1, p, visited)


tree = []
answer = 0
for _ in range(n + 1):
    r = list(map(int, input().split(' ')))
    tree.extend(r)

length = len(tree)
started = [-1] * length

leafs = []
for i in range(length):
    if tree[i] != -1:
        lc, rc = getChildren(i)
        if lc == -1 and rc == -1:
            leafs.append(i)

for leaf in leafs:
    started[leaf] = leaf
    visited = [-1] * length
    kStep(k, leaf, visited)

print(answer)

