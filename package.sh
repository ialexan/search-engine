#!/bin/bash
# Author: Ishag Alexanian
# Packaging and creating the war

export M2_HOME=/usr/local/apache-maven-3.1.0-alpha-1/
export M2=$M2_HOME/bin
export PATH=$M2:$PATH

mvn package



