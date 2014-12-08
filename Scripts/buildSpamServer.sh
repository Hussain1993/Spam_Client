#!/bin/bash
WAR_FILE="/Users/Hussain/Developer/apache-tomcat-8.0.12/webapps/SpamServer*"
PROJECT_FOLDER="/Users/Hussain/git/Spam_Server"
APACHE_FOLDER="/Users/Hussain/Developer/apache-tomcat-8.0.12/bin/startup.sh"


echo "This is going to delete and rebuild the spam server project"

read -p "Press any key to continue"

rm -rfv $WAR_FILE

echo "Deleted all the WAR files, going to build the project now"

cd $PROJECT_FOLDER

mvn clean install

$APACHE_FOLDER
