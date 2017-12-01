#!/bin/bash



while true; do

    sleep 2
    curl -H "Token: asdf" localhost:8080/ping

    sleep 2
    curl -H "Token: asdf" localhost:8080/ping

    sleep 2
    curl -H "Token: asdf" localhost:8080/ping

    sleep 2
    curl -H "Token: asdf" localhost:8080/h

done
