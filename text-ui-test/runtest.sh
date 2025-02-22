#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

# compile the code into the bin folder, terminates if error occurred
if ! javac -cp ../src/main/java -Xlint:none -d ../bin ../src/main/java/*.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ../bin Main < input.txt > ACTUAL.TXT

# convert to UNIX format
# cp EXPECTED.TXT EXPECTED-UNIX.TXT
# dos2unix ACTUAL.TXT EXPECTED-UNIX.TXT

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED.TXT
if [ $? -eq 0 ]
then
    echo "Test result (Functionality): PASSED"
else
    echo "Test result (Functionality): FAILED"
fi
rm ./taskfile.txt

java -classpath ../bin Main < input_error.txt > ACTUAL.TXT
# dos2unix ACTUAL.TXT EXPECTED-UNIX.TXT

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED_ERROR.TXT
if [ $? -eq 0 ]
then
    echo "Test result (Error Handling): PASSED"
else
    echo "Test result (Error Handling): FAILED"
fi
rm ./taskfile.txt

