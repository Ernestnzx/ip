#!/usr/bin/env bash

if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

if ! javac -cp ../src/main/java -Xlint:none -d ../bin ../src/main/java/*.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

java -classpath ../bin Main < input.txt 