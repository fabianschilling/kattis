#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys
import math

def solve(seq, n):

    # pred[k]: stores index of predecessor of seq[k] lor lincsubseq ending at seq[k]
    pred = [None] * n
    # mem[k]: stores index k of smalles value seq[k] s.t. lincsubseq of len j ending at seq[k]
    mem = [None] * (n + 1)
    # length of the lincsubseq found so far
    l = 0

    for i in range(n):

        # binary search for largest j <= l such that seq[mem[j]] < seq[i]
        lo = 1
        hi = l
        while lo <= hi:
            mid = int(math.ceil((lo + hi) / 2))
            if seq[mem[mid]] < seq[i]:
                lo = mid + 1
            else:
                hi = mid - 1

        # after search, lo is 1 greater than len of longest prefix of seq[i]
        new_l = lo

        # the pred. of seq[i] is the last index of subseq. of length new_l - 1
        pred[i] = mem[new_l - 1]
        mem[new_l] = i

        # if we found longer subseq., update
        l = max(l, new_l)

    # reconstruct solution from pred & mem
    sol = [None] * l
    k = mem[l]
    for i in reversed(range(l)):
        sol[i] = k
        k = pred[k]

    return sol

def main():
    data = sys.stdin.readlines()
    while data:
        n = int(data.pop(0))
        seq = [int(x) for x in data.pop(0).split(' ')]
        sol = solve(seq, n)
        print(len(sol))
        print(' '.join([str(x) for x in sol]))



if __name__ == '__main__':
    main()

