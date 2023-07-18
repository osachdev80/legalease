# Project Name

Short description or overview of the project.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Notes](#notes)


## Installation

Clone the repository: git@github.com:osachdev80/legalease.git
Build using mvn

## Usage

Call the following endpoint: http://localhost:8081/checkRegion/<REGION_ID>
(where regionId is passed in)

## Features
If REGION_ID is not 170, an error message will be returned otherwise it should return list of all Firm Rankings

## Notes
Currently, the REGION_ID that is received is searched in a JSON file to see if it exists, and it returns the entire data set.
However for prod I presume the data could be retrieved from an external rest call
