# Algorithms Generic Sorting HW

## Why generic sorting algorithms are slower

I believe that the chief reason for a generic sorting algorithm to run slower than a purpose-built algorithm is complexity. My version of the generic quicksort algorithm uses 6 additional functions that the purpose built does not. This could be an oversimplification but each additional call is another set of processes that have to occur and return. I read up on some profiling tools (I tried gprof and Callgrind from the Valgrind suite) and tested them on the programs. Frankly, I had a hard time understanding the output. But, it made it easier for me to see that the extra steps that the generic version had to undergo did have a significant (well in processor terms) cost in terms of processing time. Generic quicksort observes the same asymptotic behavior because it has the same structure, it just has to undergo additional steps to complete its task.
