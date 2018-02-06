#!/bin/bash
# author:chenshuaijun


# Usage: sh winter.sh start "-Xms128m -Xmx128m"
# Usage: sh winter.sh stop
# Usage: sh winter.sh status
# Usage: sh winter.sh reload 10
# Usage: sh winter.sh log

env_args="-Xms128m -Xmx128m"
sleeptime=0
arglen=$#

# get winter pid
get_pid(){
    pname="`find .. -name 'winter*.jar'`"
    pname=${pname:3}
    pid=`ps -ef | grep $pname | grep -v grep | awk '{print $2}'`
    echo "$pid"
}

startup(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        echo "winter already startup!"
    else
        jar_path=`find .. -name 'winter*.jar'`
        echo "jarfile=$jar_path"
        cmd="java $1 -jar $jar_path > ./winter.out < /dev/null &"
        echo "cmd: $cmd"
        java $1 -jar $jar_path > ./winter.out < /dev/null &
        show_log
    fi
}

shut_down(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        kill -9 $pid
        echo "winter is stop!"
    else
        echo "winter already stop!"
    fi
}

show_log(){
    tail -f winter.out
}

show_help(){
    echo -e "\r\n\t欢迎使用开科微服务系统"
    echo -e "\r\nUsage: sh winter.sh start|stop|reload|status|log"
    exit
}

show_status(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        echo "winter is running with pid: $pid"
    else
        echo "winter is stop!"
    fi
}

if [ $arglen -eq 0 ]
 then
    show_help
else
    if [ "$2" != "" ]
    then
        env_args="$2"
    fi
    case "$1" in
        "start")
            startup "$env_args"
            ;;
        "stop")
            shut_down
            ;;
        "reload")
            echo "reload"
            ;;
        "status")
            show_status
            ;;
        "log")
            show_log
            ;;
    esac
fi