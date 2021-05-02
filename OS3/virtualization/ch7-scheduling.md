# Ch.7 Scheduling

scheduling policies = disciplines

all processes together usually referred to as workload

determining workload critical part of building policies

metrics:

- **turnaround time** - time at which job completes minus start time
- **response time** - time when job arrives in system to first time it is scheduled

another metric commonly used is **fairness** with Jain's Fariness Index

examples of disciplines:
FIFO, shortest job first (SJF), shortest time to completion first (STCF), round robin

FIFO problem: convoy effect - heavy process takes too long does not consider short processes

round robins run jobs for **time-slice** (or scheduling quantum)
- length of time slice must be multiple of timer-interrupt period
- if slice too short, context switch will dominate overall performance

how to handle I/O?

when I/O completes, interrupt is raised and OS runs and moves the process that issued the I/O from blocked back to ready

one approach to split up process with multiple I/O requests is to make each "subjob" an independent job to schedule

can overlap multiple processes as switches between subjobs to maximize resources

inherent trade-off in selecting a scheduling system

**multi-level feedback queue** - uses recent past to predict the future



