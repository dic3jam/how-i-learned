CC = gcc
FLAG = -o
DFLAG = -g -o

genquicksort: main.c genquicksort.h algorithms.h
	${CC} ${FLAG} genquicksort main.c genquicksort.h algorithms.h

debug: main.c genquicksort.h algorithms.h
	${CC} ${DFLAG} debug main.c genquicksort.h algorithms.h

clean:
	rm -f genquicksort debug *.txt core
	 

