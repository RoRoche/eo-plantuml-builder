#!/bin/bash

echo "We are going to publish version $CIRCLE_SHA1"
echo $GPG_KEY_CONTENTS | base64 -d > /tmp/secret.gpg
./gradlew -PnewVersion="$CIRCLE_SHA1" clean jar publish closeAndReleaseRepository
