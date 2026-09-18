#!/usr/bin/env bash
set -euo pipefail

: "${SPORTSFOUNDRY_API_KEY:?Set SPORTSFOUNDRY_API_KEY first}"

curl --fail-with-body --silent --show-error \
  https://sportsfoundry.app/api/v1/sports \
  -H "X-API-Key: $SPORTSFOUNDRY_API_KEY"
