#!/bin/bash

echo ${GPG_KEY_CONTENTS} | base64 --decode >/tmp/secret.gpg

./gradlew -PnewVersion="$TRAVIS_TAG" clean jar publish closeAndReleaseRepository