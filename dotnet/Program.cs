using System.Net.Http.Headers;

var apiKey = Environment.GetEnvironmentVariable("SPORTSFOUNDRY_API_KEY");
if (string.IsNullOrWhiteSpace(apiKey))
{
    throw new InvalidOperationException("SPORTSFOUNDRY_API_KEY is required");
}

using var client = new HttpClient();
client.DefaultRequestHeaders.Add("X-API-Key", apiKey);

using var response = await client.GetAsync("https://sportsfoundry.app/api/v1/sports");
var body = await response.Content.ReadAsStringAsync();

if (!response.IsSuccessStatusCode)
{
    throw new InvalidOperationException($"SportsFoundry request failed: {(int)response.StatusCode} {body}");
}

Console.WriteLine(body);
