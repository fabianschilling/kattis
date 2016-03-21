#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

def quadmul(pol1, pol2):
    result = [0]*(len(pol1)+len(pol2))
    for index1, coeff1 in enumerate(pol1):
        for index2, coeff2 in enumerate(pol2):
            result[index1+index2] += coeff1*coeff2
    return result

def karatsuba(pol1, pol2):
    if len(pol1) < 10 or len(pol2) < 10:
        return quadmul(pol1, pol2)
    m = max(len(pol1), len(pol2))
    m2 = m // 2
    low1 = pol1[:m2]
    high1 = pol1[m2:]
    low2 = pol2[:m2]
    high2 = pol2[m2:]

    z0 = karatsuba(low1, low2)
    z1 = karatsuba((low1+high1), (low2+high2))
    z2 = karatsuba(high1, high2)
    return (z2*10**(2*m2)) + ((z1-z2-z0)*10**(m2))+(z0)

T = int(sys.stdin.readline().strip("\n"))

for _ in range(T):
    deg1 = int(sys.stdin.readline().strip("\n"))
    pol1 = [int(x) for x in sys.stdin.readline().strip("\n").split(" ")]
    deg2 = int(sys.stdin.readline().strip("\n"))
    pol2 = [int(x) for x in sys.stdin.readline().strip("\n").split(" ")]

    res = quadmul(pol1, pol2)
    
    deg = 0
    for index, coeff in enumerate(res):
        if coeff != 0:
            deg = index

    print deg
    print " ".join([str(x) for x in res[:deg+1]])