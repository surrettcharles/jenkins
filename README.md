# Image with automated Jenkins setup/configuration
This repository contains files for generating a Docker image based on `jenkins/jenkins:alpine`.

When the image is started for the first time it will configure some basic Jenkins settings (security, plugins, etc.) based on configuration files supplied in a volume.

## Use / Configuring Image
This is a slightly opinionated build. Certain things will be turned on or off based on current recommended hardening (CLI, JNLP, etc.). Other things will be configurable via supplied property files.

* You *must* supply the location of the configuration YAML files. By default it will expect these files in `/jenkins-config`, but this location can be overridden by supplying a value for the `CONFIG_PATH` environment variable for the container. Examples of the needed configuration files can be found in the [examples/config]() directory.
  * The authentication mechanism configured is GitHub OAuth. OAuth is my personal preferred method, as no credentials are stored locally. At some point in the future I may investigate other OAuth provider options (gitlab, google, facebook, etc.).
  * The authorization mechanism configured is the Jenkins matrix authorization. No real reason other than it being the one I found examples to use.
  * Credentials created via the initialization script are created in the default namespace at the root folder. This is something I hope to rectify in a future release, as it can quickly lead to a long list of credentials to sort through for jobs.
  * At this time all configuration files are required. You can supply an empty YAML file, but the file must exist or the startup will fail.
* You may supply job definition scripts. By default the initialization script will expect these files in `/jenkins-jobs`, but this location can be overridden by supplying a value for the `JOB_PATH` environment variable for the container. If no scripts are detected, no jobs will be created. A few examples can be found in the [examples/jobs]() directory. You can see all the available options for job configuration at the [Jenkins Job DSL API site](https://jenkinsci.github.io/job-dsl-plugin/).

## Build
The build for this image will use the latest `jenkins/jenkins:alpine` image as a base, and apply the latest version of plugins listed in `plugins.txt`.

## Versioning
This image does not follow traditional SemVersion versioning. Instead, the version is based on the build date and if it is built from `master` or a `feature/*` branch. The possible version formats are:
`YYYY.MM.R#` / `latest`: Built from `master`. The number after 'R' indicates the build number for the month.
`YYYY.MM.F#.#`: Built from a `feature/*` branch. The number after 'F' indicates which feature branch, and the number after the final '.' indicates the build number for the month.
The reasons for this version scheme are:
1. This scheme provides a clear indication of when it was built. If it hasn't been built for a while, a manual rebuild of `latest` will be performed. However, as a general practice, the latest release build should match the latest tag.
1. The build will pickup the latest version of Jenkins and plugins each time it is built. While some people would prefer a consistent build, the purpose of this image is to be a 'bleeding edge build'. Each time it is built, new plugin versions may break something. If this becomes a problem, certain plugins may become version-locked on at least a temporary basis.

## Changelog
All changes should be captured in [CHANGELOG.md](). If you're wondering what was changed as part of a specific version, look there first.
