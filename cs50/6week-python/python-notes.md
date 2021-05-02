#Main lecture

print("Hello World")

python3 "program" "args"

no semi-colons. no newlines print does automatically

get user input and print to screen:

	answer = get_string("What is your name?")
	print("hello," + answer)

+ or , will concatenate string in print. also adds space

	print(f"Hello, {answer}")

{} interpolate the value inside those. **f is format string** tells interpreter to not print literally, format the value in the {}

variables:

	counter = 0 //thats an int

	counter = counter + 1 //good

	counter += 1 //good

++ operator does not exist in python

if:

	if x < y:
		print("x is less than y")

have to use the : and the tab is important

python is sensitive to whitespace

if want to be in condition, must be indented

	if blah:
		thing to do
	elif:
		other thing to do
	else:
		other thing to do

while: 

	while True:
		print("Hello World")

booleans capitalized

for:

do not map directly to python

	for i in [0,1,2]:
		print("cough")

[] called list. can grow and shrink easily

set i eqaul to 0, cough. set i equal to 1, cough

	for i in range(3):
		print("cough'0

range(3) will return list of numbers from 0 up to 3

data types:

bool
float
int
str (string)

some of those data strcutures from C:
range- sequence of numbers
list- sequence of mutable values
tuple- sequence of immutable values
dict- collection of key value pairs (abstract data type implemented with hash table under the hood)
set- collection of unique values- will throw away duplicates'

not all of them

importing:

	from PIL import Image, ImageFilter

functions:

	words = set()

	def *name of function*(word):

dictionary.py
	
def load(dictionary):

	file = open(dictionary, "r")
	for line in file:
		words.add(line.rstrip("\n"))
	file.close()
	return True

def check(word):

	if word.lower() in words:
		return True
	else:
		return False	

def size():
	return len(words)

def unload():
	return True

logic:

literallty and , or instead of && ||


if s.lower() in ["y", "yes"]:
	print("Agreed")

can implement regular expressions

use import to pull in other files

**traceback**- what went wrong

reads line one at a time- so function definitions need to be above "main" code
one solution:

	def main()
		what main does

	def function(()
		what function does

	...at end of file

	main()

so define "main" first just remember to actually call main at end. does not need to be called main, just a convention

example:

	def get_positive_int():
		while True:
			n = get_int("Positive Integer: ")
			if n > 0:
				break
		return n

**no variable scope** within function

so not necessarily accessbile to other functions, but no scope within its own function

**input**- receives input from keyboard, but receives string

to "cast"

	age = int(input("What's your age?")

no upper bounds for variables- will overflow whole computer

**list**
	scores = [72, 73]

	scores = []
	scores.append(72)
	scores.append(33)

	print(f"Average: {sum(scores) / len(scores)}")

can grow and shrink- don't think about it

iterate over a string (string s)

	for c in s:
		print(c, end="")
	print()

**command line arguments**

	from sys import argv

	for i in range(len(argv)):
		print(argv[i])

more pythonic:

	for arg in argv:
		print(arg)

**exiting function**

from sys import exit

exit(1) instead of return 1

example:

	if "EMMA" in names:
		print("Found")
		exit(0)
	print("Not found")
	exit(1)

**dictionary**

key-value pair

takes input keys, outputs values

declaring a dict
	people = {
		"EMMA": "617-555-0101",
		"John": "453-234-5674"
	}

	if "EMMA" in people:
		print(f"Found {people['EMMA']}")

returns Emma's number

double or single quotes do same thing. here trying to keep interpreter from getting confused

**package** == library

(use import)

**Regular Expressions**

define patterns

. - any character
.\*- 0 or more characters
.+ - 1 or more characters
? - optional
^ - start of input
$ - end of input

import re (str s)

	if re.search("yes", s):

	if re.search("yes\y", s):

	if re.search("y(es)?", s):

	YES will not work

	if re.search("y(es)?", s, re.IGNORECASE):

**using libraries**

like Java object methods:

recognizer = speech_recognizer.Recognizer()

with speech_recognizer.Microphone() as source:
	print("Say something")
	audio = recognizer.listen(source)

#Shorts- Python

variables declared by initialization only

\# for comments

code blocks indented

ternary operator: 
	letters_only = True if input().isalpha() else False

input() native function for getting user input from CLI

only while and for loops. no do while

	for x in range(0, 100, 2):
		print(x)

count from 0 to 100 counting by 2s

lists are arrays BUT not fixed in size 
nums = [] //empty list 

nums = [x for x in range(500)] use for loop to create list of 500 elements 

nums.append(5) //adds to end 

nums.insert(4,5) //insert in 4th position 5 
nums[len(nums):] = [5] //could use this to tack a list onto an existing list 

**tuples**- ordered immutable set of data. useful for associating collections of data (like a struct). order is important list of tuples:
 
presidents = [ ('George Washington', 1789),
		('John Adams', 1797)
	]

	for prez, year in presidents
		print("In {1}, {0} took office".format(prez, year))

using . method operator on the string

**dictionaries**

	pizzas = {
		"cheese":9,
		"pepperoni":10 
	} 
	
	pizzas["bacon"] = 14 #add new  key/value pair

can easily iterate over a dictionary

	for pie in pizzas:   #pie becomes the keys
		print(pie)

will print all of the keys

	for pie, price in pizzas.items():
		print (price)

.items() transforming dictionary into a list

str(price) turns price into a string

\*\* built in square operator

Python is an object-oriented language

objects can have own methods defined in the object

	object.method()

define object using class keyword

every class needs a constructor

every method in class needs "self" (like this os Java)

	class Student():
		def__init__(self, name, id):
			self.name = name
			self.id = id

		def changeID(self, id):
			self.id = id

		def print(self):
			print("{} - {}".format(self.name, self.id))

initialization:

	jane= Student("Jane", 10)




	import <module>


























	
