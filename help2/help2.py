#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys

def is_var(w):
    return w[0] == '<' and w[-1] == '>'

def replace(pat, word, substitute):
    for i in range(len(pat)):
        if pat[i] == word:
            pat[i] = substitute

def find(pat1, pat2):

    for i in range(len(pat1)):
        if is_var(pat1[i]) and not is_var(pat2[i]):
            replace(pat1, pat1[i], pat2[i])
            return find(pat1, pat2)
        if not is_var(pat1[i]) and is_var(pat2[i]):
            replace(pat2, pat2[i], pat1[i])
            return find(pat1, pat2)
    for i in range(len(pat1)):
        if is_var(pat1[i]) and is_var(pat2[i]):
            replace(pat1, pat1[i], "xxx")
            replace(pat2, pat2[i], "xxx")
            return find(pat1, pat2)
    if pat1 != pat2:
        print('-')
        return
    print(" ".join(pat1))
    return

def solve(pat1, pat2):

    if len(pat1) != len(pat2):
        print('-')
        return

    find(pat1, pat2)

def main():
    input = sys.stdin.readlines()
    num_cases = int(input.pop(0))
    for i in range(num_cases):
        pat1 = input.pop(0).splitlines()[0].split(' ')
        pat2 = input.pop(0).splitlines()[0].split(' ')
        solve(pat1, pat2)

if __name__ == "__main__":
    main()