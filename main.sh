#!/bin/bash

javac -d out/ \
  src/main/java/com/example/bank/Main.java

java -cp out/ com.example.bank.Main
