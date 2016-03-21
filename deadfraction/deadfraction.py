#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys
from fractions import gcd

# solution inspired by Khan academy


def fraction(n):

    # these are the values we're looking for (min denominator!)
    bestnum = 0
    bestden = sys.maxint # high initial value!

    # try different fractions while minimizing the denominator
    for i in range(len(n)):


        a = int(n[i:])
        b = pow(10, len(n) - i) - 1
        c = 0 if i == 0 else int(n[:i])

        num = a + (b * c)
        den = b * pow(10, i)

        # try to simplify the fraction
        g = gcd(num, den)
        num /= g
        den /= g

        # minimize the denominator
        if den < bestden:
            bestnum = num
            bestden = den

    print(str(bestnum) + '/' + str(bestden))

def main():

    #data = open('/Users/fabianschilling/Downloads/deadfraction-sample-data/B.in').readlines()
    data = sys.stdin.readlines()
    #data = ['0.474612399...']

    for n in data:

        # strip away "\n" so we can check break condition
        n = n.strip('\n')

        if n == '0':
            break

        # strip "0." in the beginning and "..." in the end
        n = n[2:]
        n = n[:-3]

        fraction(n)

if __name__ == '__main__':
    main()