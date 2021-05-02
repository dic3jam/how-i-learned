


FLAG = -o
DFLAG = -g -o
CC = gcc

mergesort: main.c mergesort.h
	${CC} ${FLAG} mergesort main.c mergesort.h

debug: main.c mergesort.h
	${CC} ${DFLAG} debug main.c mergesort.h

clean:
	rm -f mergesort debug *.txt *.gdb core
