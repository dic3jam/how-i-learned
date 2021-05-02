


FLAG = -o
DFLAG = -g -o
CC = gcc

quicksort: main.c quicksort.h
	${CC} ${FLAG} quicksort main.c quicksort.h

debug: main.c quicksort.h
	${CC} ${DFLAG} debug main.c quicksort.h

clean:
	rm quicksort debug *.txt *.gdb core
