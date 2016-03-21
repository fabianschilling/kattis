#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

# conver int to str under certain base
def int2str(num, base):
    (d, m) = divmod(num, base)
    if d > 0:
        return int2str(d, base) + str(m)
    return str(m)

# convert from base 7 to (0, 1, 2, 5, 6, 8, 9) system
def convert_sys(num_str):
    ls = list(num_str)
    for i, dig in enumerate(ls):
        if dig == '3':
            ls[i] = '5'
        elif dig == '4':
            ls[i] = '6'
        elif dig == '5':
            ls[i] = '8'
        elif dig == '6':
            ls[i] = '9'
    return ''.join(ls)

nums = [int(x) for x in sys.stdin.readlines()]

for num in nums:
    num_str = list(convert_sys(int2str(num, 7))[::-1])
    # turn upside down, i.e. 6 -> 9 and 9 -> 6
    for i, char in enumerate(num_str):
        if char == '6':
            num_str[i] = '9'
        elif char == '9':
            num_str[i] = '6'
    print(''.join(num_str))