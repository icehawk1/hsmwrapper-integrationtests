FROM ubuntu:zesty
LABEL maintainer="martin.haug3@escrypt.com"

ADD . /app

WORKDIR /app/wildfly

# https://askubuntu.com/questions/89437/how-to-install-packages-with-apt-get-on-a-system-connected-via-proxy
#ENV http_proxy host:port
#ENV https_proxy host:port

# update is needed to find apt packages
RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk-headless
RUN bin/add-user.sh -u escrypt -p escrypt
RUN bin/add-user.sh -u escrypt-app -p escrypt -e -r ApplicationRealm -a -g testrole

# Make Wildfly available from outside this container
EXPOSE 9990
EXPOSE 8080
EXPOSE 8443

ENV JBOSS_HOME /app/wildfly
# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

# Run Wildfly when the container launches
CMD ["bin/standalone.sh", "-b", "0.0.0.0","-bmanagement","0.0.0.0"]