#!/bin/bash
echo "read num1"
read num1
echo "read num2"
read num2
echo "read num3"
read num3
if [ $num1 -gt $num2 ];
 then result=$(($num1 - $num2))
 echo "Result is $result"
elif [ $num3 -lt $num2 ];
 then result=$(($num3 + $num2))
 echo "Result is $result"
elif [ $num2 -eq $num3 ];
 then result=$(($num2 * $num3))
 echo "Result is $result"
fi
