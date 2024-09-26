#!/bin/sh

if [ $# -lt 1 ]; then
    echo "Error: Please provide at least one argument for file name."
    exit 1
fi

cd ~/C/qlang-q06/src/qlang_interpreter
javac *.java
if [ $# -ge 2 ]; then
    echo "$2" | java PilMain "$1"
else
    java PilMain "$1"
fi