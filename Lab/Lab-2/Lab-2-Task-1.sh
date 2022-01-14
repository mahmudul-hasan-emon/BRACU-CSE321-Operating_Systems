#!/usr/bin/bash
sum=0 
for((i=1;i<=10;i++))
do
 echo "Enter a Integer: " 
 read int 
 if (( int % 2 == 0)) && (( int % 8 != 0));
  then (( sum = sum + int ))
 fi
done
echo "Sum is: $sum" 
