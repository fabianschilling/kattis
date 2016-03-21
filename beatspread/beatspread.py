#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

data = sys.stdin.readlines()

n = int(data.pop(0))

for _ in range(n):
    s, d = [int(x) for x in data.pop(0).split(' ')]

    sm = s + d

    if sm % 2 == 1 or s < d:
        print('impossible')
    else:
        s1 = sm / 2
        s2 = s - s1
        print(str(s1) + ' ' + str(s2))
