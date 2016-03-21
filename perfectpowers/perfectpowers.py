#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys, math


def factorize(x):

    factors = {}

    i = 2
    while i * i <= x:
        while x % i == 0:
            if i in factors:
                factors[i] += 1
            else:
                factors[i] = 1
            x /= i
        i += 1

    if x > 1:
        if x in factors:
            factors[x] += 1
        else:
            factors[x] = 1

    return factors


def solve(x, positive):

    factors = factorize(x)

    max_p = int(math.log(x, 2))

    p = max_p
    while p >= 1:
        found = True
        for f in factors.values():
            if f % p != 0:
                found = False
                break
        if positive and found:
            break
        elif not positive and found and (p % 2 == 1):
            break
        p -= 1
    print(p)


def main():

    nums = [int(x) for x in sys.stdin.readlines()]

    for x in nums:

        if x == 0:
            break

        positive = True
        if x < 0:
            x = abs(x)
            positive = False

        solve(x, positive)


if __name__ == '__main__':
    main()