#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

input = map(int, sys.stdin.readlines()[0].split(" "))
N = input.pop(0)
b = input.pop(0)

if (2 ** (b + 1)) - 1 >= N:
	print("yes")
else:
	print("no")