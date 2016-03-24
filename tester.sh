#!/bin/bash
# author: Krzysztof Kucharczyk
# date  : 24.03.2016
# desc  : Easy script which makes testing more enjoyable. 
# ---------------------------------------------

echo
echo ::: Tests have been launched :::
echo ::: Please wait...           :::

mvn -l latestResult.txt test 
tail -18 latestResult.txt

echo 
echo ::: For full log, please check latestResult.txt file :::
