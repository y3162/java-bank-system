#!/bin/bash

JUNIT_VERSION="6.1.3"
JUIIT_PATH="lib/junit-platform-console-standalone-${JUNIT_VERSION}.jar"
if [ ! -f "${JUIIT_PATH}" ]; then
  JUNIT_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${JUNIT_VERSION}/junit-platform-console-standalone-${JUNIT_VERSION}.jar"
  curl -fsSL -o ${JUIIT_PATH} ${JUNIT_URL}
fi

javac -d out -classpath ${JUIIT_PATH} \
  src/main/java/com/example/bank/model/Account.java \
  src/test/java/com/example/bank/model/AccountTest.java \
  src/main/java/com/example/bank/repository/AccountRepository.java \
  src/main/java/com/example/bank/repository/InMemoryAccountRepository.java \
  src/test/java/com/example/bank/repository/InMemoryAccountRepositoryTest.java

java -jar ${JUIIT_PATH} execute \
  --class-path out \
  --select-class com.example.bank.model.AccountTest \
  --select-class com.example.bank.repository.InMemoryAccountRepositoryTest
