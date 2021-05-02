def anagram_builder(l, s):
    new_anagram = ""
    for w in s:
        if w in l:
            new_anagram += w
            l = l.replace(w, '', 1)
    return new_anagram

def len_check(anagram, l, s):
    return (len(l) - len(anagram)) + (len(s) - len(anagram))

def makeAnagram(a, b):
    if len(a) <= len(b):
        return(len_check(anagram_builder(b,a), b, a))
    else:
        return(len_check(anagram_builder(a,b), a, b))

a = "fcrxzwscanmligyxyvym"
b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke"

print(makeAnagram(a, b))
