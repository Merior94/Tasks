#!/usr/bin/env bash

#export CATALINA_HOME=/Library/Tomcat

fail() {
   echo "There were errors"
}

webbrowser() {
   open -a safari 'http://localhost:8080/crud/v1/tasks'
}

echo "Start runcrud script"
if ./runcrud.sh; then
  echo "OK!"
  webbrowser
else
   fail
fi

