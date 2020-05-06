#!/bin/bash

echo "We are going to publish version $CIRCLE_TAG"
echo $GPG_KEY_CONTENTS | base64 -d > /tmp/secret.gpg
./gradlew -PnewVersion="$CIRCLE_TAG" clean jar publish closeAndReleaseRepository
