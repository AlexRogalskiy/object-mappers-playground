@echo off

wmic process where (commandline like "%%javaw%%" and not name="wmic.exe") delete
rem ps ax | grep -i 'javaw' | grep -v grep | awk '{print $1}' | xargs kill -SIGTERM
