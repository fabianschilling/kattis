#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

# penalty for unreachable states
maxint = 999999999

def climb(n, d):

    # can never climb higher than this
    s = sum(d)

    # early exit (sum has to be even!)
    if s % 2 == 1:
        print("IMPOSSIBLE")
        return

    opt = [[maxint for x in range(s + 1)] for x in range(n)]
    dec = [[0 for x in range(s + 1)] for x in range(n)]

    # first move always goes up
    opt[0][d[0]] = d[0]
    dec[0][d[0]] = 1 # 1 = up, -1 = down

    # search greedily for right decisions
    for i in range(1, n):
        for h in range(s + 1):
            if opt[i - 1][h] != maxint:
                if h >= d[i]:
                    if opt[i][h - d[i]] > opt[i - 1][h]:
                        dec[i][h - d[i]] = -1
                        opt[i][h - d[i]] = opt[i - 1][h]
                temp_opt = max(opt[i - 1][h], h + d[i])
                if opt[i][h + d[i]] > temp_opt:
                    dec[i][h + d[i]] = 1
                    opt[i][h + d[i]] = temp_opt

    # did not reach street level
    if opt[n - 1][0] == maxint:
        print("IMPOSSIBLE")
        return

    # construct solution from optimal path
    sol = ["" for x in range(n)]
    h = 0
    for i in reversed(range(n)):
        if dec[i][h] == 1:
            h -= d[i]
            sol[i] = "U"
        else:
            h += d[i]
            sol[i] = "D"
    print("".join(sol))


cases = sys.stdin.readlines()

for i in range(int(cases.pop(0))):

    n = int(cases.pop(0))
    d = map(int, cases.pop(0).split(" "))

    climb(n, d)
