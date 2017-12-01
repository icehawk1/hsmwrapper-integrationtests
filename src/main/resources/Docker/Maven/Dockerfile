FROM ubuntu:zesty
LABEL maintainer="martin.haug3@escrypt.com"

ADD . /app

WORKDIR /app

# https://askubuntu.com/questions/89437/how-to-install-packages-with-apt-get-on-a-system-connected-via-proxy
#ENV http_proxy host:port
#ENV https_proxy host:port

# update is needed to find apt packages
RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk-headless maven git

RUN git clone https://github.com/icehawk1/hsmwrapper-integrationtests.git
WORKDIR /app/hsmwrapper-integrationtests
# Fetch the dependencies on build so we won't need to do this on run
RUN mvn install

# Fetch most recent version of repo on every run
CMD git pull
CMD ["mvn", "--offline", "install"]