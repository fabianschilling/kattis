#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

def solve(wishes, m, n):

    remainder = sum(wishes) - m # number of remaining candies

    anger = 0
    for i, wish in enumerate(wishes):
        kids = n - i # number of remaining kids
        candies = min(wish, remainder / kids)
        anger += (candies * candies)
        remainder -= candies
        #print(remainder)

    print(anger)

def main():
    input = sys.stdin.readlines()
    first = map(int, input.pop(0).split(' '))
    m = first[0] # number of candies
    n = first[1] # number of children
    wishes = map(int, input)
    wishes.sort()
    solve(wishes, m, n)

if __name__ == '__main__':
    main()