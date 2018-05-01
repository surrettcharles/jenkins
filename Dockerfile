FROM jenkins/jenkins:alpine

ARG CONFIG_PATH=/jenkins-config
COPY plugins.txt ${CONFIG_PATH}/plugins.txt
RUN /usr/local/bin/install-plugins.sh < ${CONFIG_PATH}/plugins.txt
