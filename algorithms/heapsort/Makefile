FLAG = -o
DFLAG = -g -o
CC = gcc

heapsort: main.c heapsort.h algorithms.h
	${CC} ${FLAG} heapsort main.c heapsort.h algorithms.h

debug: main.c heapsort.h algorithms.h
	${CC} ${DFLAG} debug main.c heapsort.h algorithms.h

clean: 
	rm -f heapsort debug *.txt core


