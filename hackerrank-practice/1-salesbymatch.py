#! /usr/bin/python3
# comprehend the list - if of certain type, move into its own list

import sys

ar = [2,2,3,3,3,4,4,4,5]
capture = []

for y in range(100):
    if y in ar:
        capture.append(y) 
        

print(capture)
