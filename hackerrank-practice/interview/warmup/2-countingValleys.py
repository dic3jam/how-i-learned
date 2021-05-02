
def countingValleys(steps, path):
    alt = 0
    in_val = False
    val = 0
    for x in path:
        if x == 'D':
            alt -= 1
            if alt < 0:
                if in_val == False:
                    in_val = True
                    val += 1
        elif x == 'U':
            alt += 1
            if alt >= 0:
                in_val = False
      #  print(f"x {x}, alt {alt}, in_val {in_val}, val {val}")
    return val

test = "DDUUDDUDUUUD"

print(countingValleys(len(test), test))


