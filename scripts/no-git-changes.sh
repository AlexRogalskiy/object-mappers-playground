#!/usr/bin/env bash

set -euo pipefail
set -x

# make sure there are no local changes to repository after build
if [ -z $(git status --porcelain) ];
then
  echo "No changes detected, all good"
else
  echo "The following files have formatting changes:"
  git status --porcelain
  echo ""
  echo "Please run 'mvn clean install' locally to format files"
  exit 1
fi
