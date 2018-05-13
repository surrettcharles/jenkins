# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/).

## [Unreleased]
### Added

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [2018.5.R3]
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

## [2018.5.R2]
### Added
- Jenkins initialization script to disable the install setup step

## [2018.5.R1]
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
