# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/).

## [Unreleased]
### Added
-

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [2018.5.R6]
### Added
- Added `greenballs`, `ssh-agent`, and `ws-cleanup` plugins

### Changed
- Updated `multiBranch.groovy` to show how to trigger indexing after a rebuild

### Fixed
- Updated logic in `1-DisableAdminSetup.groovy` so an NPE is not thrown on container restarts

## [2018.5.R5]
### Added
- Added initialization script to import credentials. All credentials are created at the root folder.
- Added logging to indicate no jobs found during initialization

## [2018.5.R4]
### Added
- Updated script to not fail if job folder is not supplied

## [2018.5.R3]
### Added
- Added job-dsl to plugin list
- Added initialization script to process DSL job definitions
- Added JOB_PATH environment variable to `Dockerfile`

## [2018.5.R2]
### Added
- Added matrix-auth to plugin list
- Added script to configure system properties
- Updated `Jenkinsfile` to set the build description to the build version

### Security
- Disabled CLI access
- Added GitHub OAuth configuration
- Enabled CSRF protection
- Disabled JNLP protocols
- Enabled Agent --> Master security subsystem

## [2018.5.R1]
### Added
- Jenkins initialization script to disable the install setup step

## [2018.5.R0]
### Added
- Automation scripts to build/tag the version as it's built
- Initial plugin list
  - github-oauth
  - pipeline-github
  - pipeline-github-lib
  - pipeline-githubnotify-step
  - pipeline-model-definition
  - pipeline-utility-steps
  - sonar
  - sonar-quality-gates
  - timestamper
  - versionnumber
