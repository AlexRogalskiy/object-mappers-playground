#!/usr/bin/env bash

function increment() {
  local version=$1
  result=$(echo ${version} | awk -F. -v OFS=. 'NF==1{print ++$NF}; NF>1{if(length($NF+1)>length($NF))$(NF-1)++; $NF=sprintf("%0*d", length($NF), ($NF+1)%(10^length($NF))); print}')
  echo "${result}-SNAPSHOT"
}

# extract the release version from the pom file
version=$(./mvnw -o help:evaluate -N -Dexpression=project.version | sed -n '/^[0-9]/p')
tag=$(echo ${version} | cut -d'-' -f 1)

# determine the next snapshot version
snapshot=$(increment ${tag})

echo "release version is: ${tag} and next snapshot is: ${snapshot}"

# Update the versions, removing the snapshots, then create a new tag for the release, this will
# start the travis-ci release process.
./mvnw -B versions:set scm:checkin -DremoveSnapshot -DgenerateBackupPoms=false -Dmessage="prepare release ${tag}" -DpushChanges=false

# tag the release
echo "pushing tag ${tag}"
./mvnw scm:tag

# Update the versions to the next snapshot
./mvnw -B versions:set scm:checkin -DnewVersion="${snapshot}" -DgenerateBackupPoms=false -Dmessage="[travis skip] updating versions to next development iteration ${snapshot}"
