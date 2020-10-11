#!/bin/bash

test -d forest && /bin/rm -fr ./forest
mkdir forest
cd forest

for ((i=0; i<200; i++))
	do
		echo "Creating folder $i"
		mkdir folder$i
done
