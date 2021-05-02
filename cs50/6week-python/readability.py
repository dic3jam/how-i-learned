#Readability.py

import sys
import re

#Receive the text
print("Text: ")

try:
    text = input()
except:
    print("Text only nerd")
    exit(1)

#Parse the text with regex

letters = re.findall("\w", text)
words = re.findall("\s", text)
sentences = re.findall('[!.?]',text)

#Apply index

index = (0.0588 * (100 * (len(letters)/len(words)))) - (0.296 * (100 * (len(sentences)/len(words)))) - 15.8

index = round(index)

#Return the result

if (index >= 16):
    print("Grade 16+")
elif (index < 1):
    print("Before Grade 1")
else:
    print("Grade " + str(index))
 
