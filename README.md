1) Maven Project with GraalVM Profile 
Steps to run the Maven Project with GraalVM Profile

#### Basic Setup 

1) Added the org.graalvm.buildtools with native-maven-plugin to build the project targeting the graalvm

```
mvn clean
```

```
mvn -Pnative package
```

```
./target/InterviewIDE-1.0.jar
```
