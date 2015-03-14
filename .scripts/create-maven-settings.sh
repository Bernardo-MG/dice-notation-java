#!/bin/bash
# This script creates the Maven settings file
# This includes the connection settings, which are loaded from the server's environment

{
   echo "<settings>";
   # Servers settings
   echo "<servers>";
   # Releases FTP
   echo "<server>";
      echo "<id>\${env.FTP_RELEASES_ID}</id>";
      echo "<username>\${env.FTP_RELEASES_USER}</username>";
      echo "<password>\${env.FTP_RELEASES_PASSWORD}</password>";
   echo "</server>";
   # Snapshots FTP
   echo "<server>";
      echo "<id>\${env.FTP_SNAPSHOTS_ID}</id>";
      echo "<username>\${env.FTP_SNAPSHOTS_USER}</username>";
      echo "<password>\${env.FTP_SNAPSHOTS_PASSWORD}</password>";
   echo "</server>";
   # Site FTP
   echo "<server>";
      echo "<id>\${env.FTP_SITE_ID}</id>";
      echo "<username>\${env.FTP_SITE_USER}</username>";
      echo "<password>\${env.FTP_SITE_PASSWORD}</password>";
   echo "</server>";
   # Development site FTP
   echo "<server>";
      echo "<id>\${env.FTP_SITE_DEVELOP_ID}</id>";
      echo "<username>\${env.FTP_SITE_DEVELOP_USER}</username>";
      echo "<password>\${env.FTP_SITE_DEVELOP_PASSWORD}</password>";
   echo "</server>";
   
   echo "</servers>";
   
   # Active profile
   if [ "$TRAVIS_BRANCH" == "develop" ]; then
      echo "<activeProfiles>"
         echo "<activeProfile>development</activeProfile>"
      echo "</activeProfiles>"
   fi
   
   echo "</settings>";
} >> ~/settings.xml