# Grabs our JRE to run our java application as well as tomcat since they are both Java apps
# it also grabs tomcat files for us as well
from tomcat:8.0-jre8

# We need to copy the .war file and paste it for our docker image
copy /target/rest.war /usr/local/tomcat/webapps

# Copy the database.properties and paste it for our docker image
# copy src/main/resources/database.properties /usr/local/tomcat/webapps

#Exposing port 8080
expose 8080

# This is how we run our tomcat
CMD ["catalina.sh", "run"]