#Bonus Day 1 Object Oriented Programming Languages

**object**- independent and reusable section of software code that can perform a specific task and store specified dta related to that task

can also use procedures but emphasize the practice of objects

## Object Oriented Constructs

implementation of these features makes a language object oriented:

	1. polymorphism
	2. encapsulation
	3. inheritance

**reuse** could be considered fourth- but if implement the 3 key features, reuse automatic

**polymorphism**- program is able to adapt automatically

ex: listing with 2 functions with same name draw circle 2 sets of inputs- based on inputs program chooses which version to use

**encapsulation**- create objects that are self-contained. black boxes- user does not need to know how they work just how to use them

if change parameter, function will still work across programs

objects will store input

**inheritance**- capability to create new objects that expand the characterisitics of existing objects

ex: having an object that draws a square, then creating an object that draws a cube by INHERITING some functionality from the square object

most common types of programs created with C++:

	1. executables- run by OS
	2. libraries- routines created to link to other programs being created
	3. dynamic linked libraries- reside in memory and be linked to other programs at runtime
	4. controls- routines created that can be used in the creation of other programs

##The Java Programming Language

Java more inflexible than C to remove complexity, add portability. Java REQUIRES use object oriented concepts- C++ optional

java applets or applications not translated all the way to machine code- intermediate step called **bytecode** allows for transfer 
to different architectures where each one has its own **interpreter called a Java Virtual Machine**

java adds packages also called **class libraries** to streamline and simplify reuse of classes (objects)

each package defines a separate namespace and a class name needs to be unique within its own namespace

**application** full fledged program designed to run on its own 

**applet**- designed to be distributed over the internet and executed in a browser

comprehensive set of libraries to perform functions such as screen display, networkig, internet access etc.


