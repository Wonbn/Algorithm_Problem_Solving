import sys
input = sys.stdin.readline

num = int(input())
nlist = []

for _ in range(num):
    nlist.append(int(input()))

nlist.sort()
for n in nlist:
    print(n)