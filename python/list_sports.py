import json
import os
import urllib.request

api_key = os.environ["SPORTSFOUNDRY_API_KEY"]
request = urllib.request.Request(
    "https://sportsfoundry.app/api/v1/sports",
    headers={"X-API-Key": api_key},
)
with urllib.request.urlopen(request) as response:
    print(json.dumps(json.load(response), indent=2))
