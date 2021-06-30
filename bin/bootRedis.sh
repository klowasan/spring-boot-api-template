#!/bin/sh

# 既に起動していたら停止
/usr/local/bin/docker container stop redis > /dev/null 2>&1

# 起動していたプロセスの削除
/usr/local/bin/docker container rm redis > /dev/null 2>&1

# 起動
/usr/local/bin/docker run --name redis \
    -p 6379:6379 \
    redis:6.2

# 立ち上がるまで少し待つ
sleep 5