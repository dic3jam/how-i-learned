# Ch.9 Scheduling: Proportional Share

proportional share of fair share scheduling

instead of optimizing for turnaround or response time, guarantee each job certain percentage of CPU

one method: **lottery scheduling**

lottery determines which process should get to run next 
processes that are more important get more chances to win the lottery

## 9.1 Tickets Represent your Share

**tickets** - used to represent the share of a resource
- % of tickets that a process has represents its share of the system resource in question

scheduler must know how many total tickets there are scheduler then picks a "winning ticket" 
- if process A holds ticket 0 to 74 and process B has 75 to 99, then random number generator picks a winning ticket
- so A has more chances to win

leads to probabilistic correctness in meeting desires proportion, but not guarantee
- gets better longer jobs run

## 9.2 Ticket Mechanisms

provides a number of mechanisms to manipulate tickets in useful ways

one way: **ticket currency** - allows user with a set of tickets to allocate tickets among their own jobs - aka virtualize a set of a global ticket number to each user, then convert that back to a global value when actually processing it

another mechanism: **ticket transfer** - with transfers, a process can temporarily hand off its ticekts to another process

**ticket inflation** - process can temporarily raise or lower the number of tickets it owns 

inflation can be applied in an environment where a group of processes trusts one another

## 9.3 Implementation

lottery is simple

scheduling decision code iterates through each processes tickets, adds them to a counter
when matches the randomly generated value, runs that process currently pointing at

may be best to keep data stucture of processes sorted - ensures less iterations over structure

## 9.4 An Example

would like to jobs started at same time with same tickets and same run time to finish at same time - but not always the case with randomness

to quantify this, use a **unfairness metric** first job completed divided by time second job completes
- so as jobs finish closer together, unfairness approaches 1

when job lengths are not that long, unfairness can be quite severe

## 9.5 all this says is problem with anything not CFS is how to assign tickets?

## 9.6 Why not deterministic

**stride scheduling** - each job in system has a **stride** which is inverse in proportion to the number of tickets a process has

so if use some arbitrary large value like 10,000, and process has 50, thats 50/10,000 the stride would be 10,000/50 or 200

every time a process runs, increment a counter for it (called **pass value**) by its stride to track its global process

then run the process with lowest value next **by its stride to track its global process**

have to have some global state for fairness

## 9.7 The Linux Completely Fair Scheduler (CFS)

fair share scheduling in a very scalable way

spend very little CPU cycles making scheduling decisions

to divide CPU utilization evenly among all competing processes does so with counting based technique: **virtual runtime** (vruntime)

as each process runs it accumulates vruntime

in basic case, vruntime increases at same rate

CFS will pick the process with the lowest vruntime to run next


soooo how does the scheduler know when to stop the currently running process and start the next one?
- tension: if CFS switches too often fairness is increased, but at the cost of performance (too much context switching)
if switches less often, performance is increased but at the cost of near term fairness

CFS manages this tension throught various control parameters:

1. **sched-latency** CFS uses this value to determine how long one process should run before considering a switch
- effectively determines time slice on per job basis / dynamically
- typical value is 48 ms

CFS divides sched_latency by number of processes running on the CPU to determine the time slice for a process - so overtime the CFS is COMPLETELY fair

what if!? too many processes running? - wouldn't the time slices be too small?

sets:
2. **min-granularity** - usually 6ms - the lowest a time slice can go

3. **Weighting (Niceness)**
- also adds process priority users can set
- the **nice** level of a process
- can be anywhere from - 20 to + 19
- negative numbers are better

static const int prio_to_weight[40] is an int array with all of the possible weights that nice draws from (pg 97)

formula for computing effective time slice based on sched_latency and factoring in niceness:

time_slice(k) = weight(k)/ (sumnation of as n goes from 0 to n-1)weight(k)  *  sched__latency

formula for vruntime becomes:
for process i

vruntime(i) = vruntime(i) + weight(0) / weight(i) * runtime(i)

CSF uses a red-black tree - a type of balanced tree that maintains consistent tree depth - to make scheduler find next job as quickly as possible
- only keeps track of running ( or runnable) jobs - if process goes to sleep from I/O or waiting on network then removed from CFS red-black tree
- jobs are ordered in the tree by vruntime
- insertion and deletion O(logn)

when a job sleeps and wakes up its vruntime is set to the minimum value found in the tree (prevents process sitting behind because vruntime not updating with call from taking over CPU)

CFS like weighted round-robin with dynamic time slices

still not answered: 
- jobs that sleep frequently are not treated fairly
- initial ticket/priority assignment




