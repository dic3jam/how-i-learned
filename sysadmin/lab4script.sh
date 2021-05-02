#!/bin/bash

cards="/home/dic3jam/Desktop/notebook/2230-SysAdm/4week/test/cards.txt"
details="/home/dic3jam/Desktop/notebook/2230-SysAdm/4week/test/details.txt"
test="/home/dic3jam/Desktop/notebook/2230-SysAdm/4week/test/"

mkdir age{1,2,3}

cd "age1" 
mkdir $(grep -oE "(\w+)\s+age1" "$cards" | cut -d " " -f1 | uniq) 
cd "../age2" 
mkdir $(grep -oE "(\w+)\s+age2" "$cards" | cut -d " " -f1 | uniq) 
cd "../age3" 
mkdir $(grep -oE "(\w+)\s+age3" "$cards" | cut -d " " -f1 | uniq)

x=1

while [ $x -le 77 ]
do
i=$(awk 'NR=='$x' { print $3 }' "$cards" | tr -d '\n')
cd "$i"
a=$(awk 'NR=='$x' { print $2 }' "$cards")
cd "$a"
b=$(awk 'NR=='$x' { print $0 }' "$details" | grep -oE "^\w+\s?\w+")
touch "$b"
chmod a+w "$b"
awk 'NR=='$x' { $1=""; print $0 }' "$details" | sed -e 's/^[\s]*//' > "$b"
x=$((x+1))
cd "$test"
done

