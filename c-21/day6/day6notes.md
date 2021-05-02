# Day 6 Basic Program Control

**array**- indexed group of data storage locations that have the same name and are distinguished from each other by subscript or index

arrays must be declared. type, name , size

subscript of array can be another variable

**for statement**- executes a block of one or more statements a certain number of times

for ( initial ; condition ; increment )

statement;

exits loop when condition = 0

can omit init and increment just leave ; for ex: for ( ; condition ; ) (which is basically just a while loop)

init can be any valid c expression, can be concatted with commas:

for ( ("Sorting..."), x=0 ; condtion ; increment )

; can be a statement

can nest these functions- example of printing box of Xs on pg. 131

**while statement**- executes a block of statements as long as a specified condition is true

while (condition)

statement;

when initialization and updating are required, usually use **for**. when only having condition trying to meet, use **while**. need statements to be executed at least once use **do...while**

**do...while**- tests for condition at end of loop rather than beginning. statements are always executed at least once

do
{
statements;
}while (condition);
