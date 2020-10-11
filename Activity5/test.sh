#!/bin/bash

javac RandomTest.java
for ((i=0; i<100; i++))
do
  java RandomTest 10
done

echo For numRandoms = $numRandoms pass rate = $passRate
