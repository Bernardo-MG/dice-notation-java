#!/bin/bash
# This script deploys the Maven site using the POM configuration
# It is triggered only commits to the master branch. Pulls are ignored
# Also, it will only deploy on a concrete JDK version

if [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_JDK_VERSION" == "$JDK_DEPLOY" ] && [[ "$TRAVIS_BRANCH" == "master" || "$TRAVIS_BRANCH" == "develop" ]]; then

   echo "Deploying Maven site"

   mvn site site:deploy --settings ~/settings.xml > site_output.txt
	  
   head -50 site_output.txt
   echo " "
   echo "(...)"
   echo " "
   tail -50 site_output.txt

else

   echo "Maven site won't be deployed"

fi
