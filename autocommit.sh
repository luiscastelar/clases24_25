#! /bin/bash
let message;

while getopts m: FLAG; do
  case "${FLAG}" in
    m) message="${OPTARG}";;
    *) exit -1;;
  esac
done
#if [[ $# -eq 0 ]]; then
#  message="Commit for $date"
#else
#  message="$1"
#fi

# Date in format Day-Month-Year
date=$(date +"%Y-%m-%d %T")
TS=$(date +"%Y-%m-%d %T")
if [[ ${#message} -eq 0 ]]; then
  message="Commit for $date"
fi


# Commit message
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
