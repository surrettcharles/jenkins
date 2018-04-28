# Image with automated Jenkins setup/configuration
This repository contains files for generating a Docker image based on `jenkins/jenkins:alpine`.

When the image is started for the first time it will configure some basic Jenkins settings (security, plugins, etc.) based on configuration files supplied in a volume.
