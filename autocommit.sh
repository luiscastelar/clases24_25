#! /bin/bash

# Date in format Day-Month-Year
date=$(date +"%Y-%m-%d %T")
TS=$(date +"%Y-%m-%d %T")

# Commit message
message="Commit for $date"
DIR=$(dirname "$0")
cd "$DIR"
git add .
git commit -m"${message}"
status="$(git status --branch --porcelain)"
echo "$TS -> $status" >> "${DIR}/autocommit.log"
if [ "$status" == "## master...origin/master" ]; then
  echo "IT IS CLEAN" >> "${DIR}/autocommit.log"
else
  echo "There is stuff to push" >> "${DIR}/autocommit.log"
  git push -u origin main
fi
