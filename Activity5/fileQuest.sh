#!/bin/bash

#find ~ -name "[A-Za-z].java" -print
# countlines.sh
total=0
for current in $(find ~ -name "*[A-Za-z].java" -print)
do
#	total=$[total+($(wc -l $current | awk '{print $1}'))]
#	echo -n 'total=' $total
#	echo -e -n '\r'
	echo $(wc -l $current | awk '{print $1}') $current
done | sort | head
#echo 'total=' $total
