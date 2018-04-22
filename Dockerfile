FROM jenkins/jenkins:alpine

ARG CONFIG_PATH=/jenkins-config
RUN /usr/local/bin/install-plugins.sh < ${CONFIG_PATH}/plugins.txt
