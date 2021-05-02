#! /usr/bin/python3

from matplotlib import pyplot
import sys
import re

trial_num = re.compile(r"(\d+),\d.\d+")
time = re.compile(r"\d+,(\d.\d+)")

trials = []
times = []

# import comma separated list
try:
    inputFile = sys.argv[1]
except IndexError:
    sys.exit(1)
except FileNotFoundError:
    sys.exit(1)

readFile = open(inputFile, "r")

for line in readFile:
    trials.append(trial_num.findall(line)[0])
    times.append(time.findall(line)[0])

# Plot

pyplot.scatter(trials, times)

pyplot.show()

