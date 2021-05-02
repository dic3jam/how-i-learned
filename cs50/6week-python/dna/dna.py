import csv
import sys

#assign command line arguments
if len(sys.argv) > 3 or len(sys.argv) < 1:
    print("Incorrect command line arguments")
    exit(1)

people = str(sys.argv[1])

seq = str(sys.argv[2])

#import the people 
try:
    peopleFile = open(people, "r")
    csv_reader = csv.reader(peopleFile, delimiter=',')
except:
    print("Unable to open people file")
    exit(1)

peeps = []

for row in csv_reader:
    peeps.append(row) 

#print(peeps)

#import the dna sequence
try:
    seqFile = open(seq, "r")
except:
    print("Unable to open sequence file")
    exit(1)
  
#assign the sequence to a string
for line in seqFile:
    sequence = line

#begin finding sequences
#while return is not -1, creeper starting at first instance of dna seq, then find next instance, if next instance is lenofseq away, increment counter, if not compare to maxcounter, if greater assign to max counter

seqCounts = {"AGATC":0,"TTTTTTCT":0,"AATG":0,"TCTAG":0,"GATA":0,"TATC":0,"GAAA":0,"TCTG":0,"AGAT": 0} 

for x in seqCounts:
    maxcounter = 0
    end = 0
     
    start = 0
    end = 0
    counter = 0

    end = sequence.find(x,start)
       
    print(str(end))

    if(sequence[end:len(x)] == x):
        counter = counter + 1
        start = end + len(x)

    print(str(counter))
       
    if(counter >= maxcounter):
        maxcounter = counter

    seqCounts[x] = maxcounter 

print(seqCounts)

#close files
peopleFile.close()
seqFile.close()






