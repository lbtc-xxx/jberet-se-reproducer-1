#!/bin/sh
WILDFLY_HOME=/Users/kyle/servers/wildfly-8.2.0.Final
H2_JAR=$WILDFLY_HOME/modules/system/layers/base/com/h2database/h2/main/h2*.jar
java -cp $H2_JAR org.h2.tools.Shell -url "jdbc:h2:./target/mydb" -sql "select * from forex"
