const apiKey = process.env.SPORTSFOUNDRY_API_KEY;
if (!apiKey) {
  throw new Error("SPORTSFOUNDRY_API_KEY is required");
}

const response = await fetch("https://sportsfoundry.app/api/v1/sports", {
  headers: { "X-API-Key": apiKey },
});

if (!response.ok) {
  throw new Error(`SportsFoundry request failed: ${response.status} ${await response.text()}`);
}

console.log(JSON.stringify(await response.json(), null, 2));
