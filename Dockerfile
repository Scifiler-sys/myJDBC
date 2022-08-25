# FROM instruction is used to download whatever dependencies our application needs
# In this case, we need tomcat and JRE to run our application
# Later when we build this image, pay attention to the terminal and you can actually see it downloading a bunch of files
from tomcat:8.0-jre8

# COPY instruction is used to copy whatever is actually in your computer and paste it to our docker image
# We need to copy the .war file and paste it for our docker image
# /usr/local/tomcat folders came from downloading the tomcat8 in the from instruction
copy /target/rest.war /usr/local/tomcat/webapps

expose 8080

# CMD instruction gives docker the default way of how to execute this image
# Tomcat documentation mentions to use catalina.sh to run the app
CMD ["catalina.sh", "run"]