#!/usr/bin/env bash

cp /Users/jamesbloom/.m2/repository/org/mock-server/mockserver-netty/5.14.1-SNAPSHOT/mockserver-netty-5.14.1-SNAPSHOT-jar-with-dependencies.jar ./mockserver-netty-jar-with-dependencies.jar
docker build --no-cache -t mockserver/mockserver:local-snapshot .
