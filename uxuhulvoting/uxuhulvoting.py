#!/usr/bin/python

__author__ = "Fabian Schilling"
__email__ = "fabsch@kth.se"

import sys


def solve(prefs, states, priest, state):

    if priest == len(prefs):
        return state  # no more priests left, state is final
    elif states[priest][state] is not None:
        return states[priest][state]  # state already computed

    best = None
    for i in range(3):  # every priest has three possible stone flips
        vote = (state ^ (1 << i))
        result = solve(prefs, states, priest + 1, vote)

        # the lower the preference the better
        if best is None or prefs[priest][result] < prefs[priest][best]:
            best = result

    # save the best state for the current priest and return
    states[priest][state] = best
    return best


def main(args):

    data = sys.stdin.readlines()

    n = int(data.pop(0)) # number of voting rounds

    for i in range(n):

        m = int(data.pop(0))  # number of voting priests

        prefs = []  # preferences for each priest
        states = [[None for _ in range(8)] for _ in range(m)]  # saved states

        for priest in range(m):
            prefs.append([int(x) - 1 for x in data.pop(0).split()])  # normalize to 0-7

        state = solve(prefs, states, 0, 0)  # solve for priest 0 and state 0 (=NNN)

        # print final state (0 = N, 1 = Y)
        endstate = '{:03b}'.format(state)
        sol = []
        for c in endstate:
            if c == '0':
                sol.append('N')
            else:
                sol.append('Y')
        print(''.join(sol))


if __name__ == '__main__':
    main(sys.argv)