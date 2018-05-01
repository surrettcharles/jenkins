# Image with automated Jenkins setup/configuration
This repository contains files for generating a Docker image based on `jenkins/jenkins:alpine`.

When the image is started for the first time it will configure some basic Jenkins settings (security, plugins, etc.) based on configuration files supplied in a volume.

## Build
The build for this image will use the latest `jenkins/jenkins:alpine` image as a base, and apply the latest version of plugins listed in `plugins.txt`.

## Versioning
This image does not follow SemVersion versioning. Instead, the version is based on the build date and if it is built from `master` or a `feature/*` branch. The possible version formats are:
`YYYY.MM.R#` / `latest`: Built from `master`. The number after 'R' indicates the build number for the month.
`YYYY.MM.F#.#`: Built from a `feature/*` branch. The number after 'F' indicates which feature branch, and the number after the final '.' indicates the build number for the month.
The reasons for this version scheme are:
1. This scheme provides a clear indication of when it was built. If it hasn't been built for a while, a manual rebuild of `latest` will be performed. However, as a general practice, the latest release build should match the latest tag.
1. The build will pickup the latest version of Jenkins and plugins each time it is built. While some people would prefer a consistent build, the purpose of this image is to be a 'bleeding edge build'. Each time it is built, new plugin versions may break something. If this becomes a problem, certain plugins may become version-locked on at least a temporary basis.

## Changelog
All changes should be captured in [CHANGELOG.md](). If you're wondering what was changed as part of a specific version, look there first.
