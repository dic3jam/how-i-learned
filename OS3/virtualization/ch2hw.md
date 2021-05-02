
1. 100%. I know it is 100% because we specified 5 instructions each using cpu 100% of time

2. 6 cycles + ioTime. 

3. I was wrong it now takes 6 cycles. The schduler calls the io and switches to process 1 to execute those 4 instructions

4. I predict that the switch-on-end flag will make the processor wait until the io request returns and process 0 ends before switching to process 1.
Result: That happened

5. switch_on_io causes it to switch to another process when IO initiated making it more efficient

6. Predict: initiate all 3 IO requests, run all the other processes then jump back to IO
Result: ran 1 IO request then ran the 3 processes in their entirety then went back and ran the other two
System resources are not being effectively utilized

7. Predict: match my 6. prediction
Result: runs an IO, runs process until IO request returned then immediately makes the next IO call, then runs processes

8. 

