#!/bin/sh

BASE_DIR=`dirname $0`/..

BASE_DIR=`(cd "$BASE_DIR"; pwd)`

if [ ! -f "$JAVA_HOME/bin/java" ];then echo "Please set the JAVA_HOME variable in your environment, We need java(x64)!";exit 1;fi
JAVA="$JAVA_HOME/bin/java"

#===========================================================================================
# JVM Configuration
#===========================================================================================
JAVA_OPT="${JAVA_OPT} -server -Xmx128m -Xms128m"
JAVA_OPT="${JAVA_OPT} -cp .:$BASE_DIR/conf:$BASE_DIR/lib/*"

$JAVA ${JAVA_OPT} org.myberry.site.ServerStartup &