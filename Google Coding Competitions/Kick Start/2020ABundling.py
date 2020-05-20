import sys

class TrieNode: 
    def __init__(self):
        self.children = [None for i in range(26)]
        self.count = 0

def insert(string, root):
    curr = root 
    for i in range(len(string)):
        c = string[i]
        index = ord(c) - ord('A')
        if not curr.children[index]: 
            curr.children[index] = TrieNode() 
        curr = curr.children[index] 
    curr.count += 1
  
def dfs(curr, level, k):
    global ans
    for i in range(26):
        if curr.children[i]:
            dfs(curr.children[i], level + 1, k)
            curr.count += curr.children[i].count

    while curr.count >= k:
        curr.count -= k
        ans += level

t = int(input())
for tc in range(1, t + 1):
    n, k = map(int, input().split(' '))
    ans = 0
    root = TrieNode()
    for i in range(n):
        w = input()
        insert(w, root)

    dfs(root, 0, k)
    
    print("Case #" + str(tc) + ": " + str(ans))
