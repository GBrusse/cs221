#!/bin/bash
STR="Hello world from $(hostname)!"
echo $STR

vendor=$(lscpu | grep vendor)
echo $vendor
