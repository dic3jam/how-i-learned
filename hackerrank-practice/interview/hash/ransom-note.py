""" this solution timed out
def checkMagazine(magazine, note):
    for word in note:
        if word in magazine:
            magazine.remove(word)
            continue
        else:
            print("No")
            return
    print("Yes")
"""
def checkMagazine(magazine, note):
    mag_dict = {}
    for word in magazine:
        if word in mag_dict:
            mag_dict[word] += 1
        else:
            mag_dict[word] = 1

    for word in note:
        try:
            if mag_dict[word] >= 1:
                mag_dict[word] -= 1
            else:
                print("No")
                return
        except KeyError:
            print("No")
            return
    print("Yes")





magazine = ["two", "times", "three", "not", "four", "two", "two", "two"]
note = ["two", "times", "two", "is", "four"]

checkMagazine(magazine, note)
