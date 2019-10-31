#!/bin/bash
pid=`ps -ef | grep "onlinetool-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}'`
echo "pid:" $pid
if [ -n "$pid" ]
then
   echo "kill -9 的pid:" $pid
   kill -9 $pid
fi
BUILD_ID=dontKillMe nohup java -jar onlinetool-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod >/dev/null 2>&1 &