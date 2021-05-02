# Ch.8 Scheduling: The Multi-Level Feedback Queue

1. optimize turn around time
- done by running shorter jobs first - BUT OS does not known job lengths prior to execution

2. make system feel responsive by optimizng response time

question is how can scheduler learn characteristics of running jobs then leverage that info for better scheduling

## MLFQ Basic Rules

number of queues each assigned a priority level

round robin applied to multiple jobs in particular priority queue

Rules
--------
1. if priority(A) > Priority(B), A runs (B does not)
2. if priority(A) == Priority(B), A and B run in RR
3. when a job enters the system, it is placed at the highest priority

## how to change priority

2 extremes of jobs:
1. short-running (frequently relinquish CPU) 
2. longer running "CPU-bound" jobs that need a lot of CPU time but response time is not important

approximates SJF because:

- all jobs start at highest priority
- if longer job, will move down priority queues

if an interactive job doing a lot of I/O, it will relinquish the CPU before its time slice is complete

this kinda creates 2 problems: starvation - if too many interactive jobs consume all of the CPUs time
can game the scheduler to consume CPU resources at the right intervals to block other processes

one technique to overcome these is the **priority boost** whereby all jobs priority gets raised periodically

question is what should that time be?

something else to help is better accounting

Rules cont
--------------
4. when a job uses up its allotment at a given level (regardless of how many times it has given up the CPU) its priority is reduced
5. after some time period S, move all the jobs in the system to the topmost queue

no good answer on how many queues there should be or how big should each time slice be

most MLFQs vary time slice across different queues where higher priority have short slices increase as go down
some use decaying times
some allow user to provide **advice** on priorities


