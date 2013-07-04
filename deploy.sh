#!/bin/bash
# Author: Ishag Alexanian
# Deploying the war 

TOMCAT=/home/ec2-user/apache-tomcat-7.0.40/webapps


rm -rf $TOMCAT/seck-web-0.0.6-dev.war
rm -rf $TOMCAT/seck-web-0.0.6-dev

cp /home/ec2-user/search-engine/seck-web/target/seck-web-0.0.6-dev.war $TOMCAT/seck-web-0.0.6-dev.war


