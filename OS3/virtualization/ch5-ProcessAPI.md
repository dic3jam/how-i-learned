# ch.5 Process API

exec() fork() wait()

## fork()

creates a new process

exact copy of calling process

child does not start at main() but at same location parent called fork()

child gets own address space/other resources

fork() returns to parent int PID, child receives 0

not deterministic as to whether parent or child process executes first

## wait()

call after fork, parent will WAIT until child process completes

## exec()

run program different than calling program

transforms currently running program into different program

loads code and static data from executable and overwrites the current process data
heap, stack, other parts memory space re-initialized

almost as if calling program never existed

successful call to exec() never returns

## why?

can run code AFTER call to fork()

can run code BEFORE call to exec()
- alter environment about to be run

how shell works (as example):
1. finds executable
2. calls fork() to create child of shell to run command
3. some variant of exec() in that child to run it
4. then calls wait() 
5. when child completes, shell returns from eait() then ready to accept prompt

ex: wc p1.c > results.txt

before calling exec() for wc shell closes standard output file and opens results.txt

pipe() output of one process connected to in-kernal pipe (aka queue) and input of another process is connected to same pipe

## process control

kill() sends signals to a process

ctrl-c SIGINT. interrupt. normally kills process

ctrl-z SIGSTP. stop. pauses process

can also send to whole process group

process should use signal() to "catch" various signals ensuring a partciluar system call is delivered to a process
it will suspend execution and run a particular piece of code in response




