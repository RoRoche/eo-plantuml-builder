#!/bin/bash

echo $GPG_KEY_CONTENTS | base64 -d > /tmp/secret.gpg
./gradlew -PnewVersion="$VERSION" clean jar publish closeAndReleaseRepository
