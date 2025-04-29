<h2>INSTRUCTIONS...</h2>

<h3>INITIAL LOGIN - Must be done once per week.</h3>

Follow login instructions in the console to login.
Once a blank webpage is loaded, copy the url and paste into console and press ENTER.
The access token, refresh token, and account keys will be saved to your auth file path.
You will need to login like this once per week.

Auth info is saved locally. A path can be provided or left null.

```kotlin
fun main() {
    val csApi = CsApi.buildApi("your-key", "your-secret", "path/to/save/auth.json")
    csApi.login()
}
```


<h3>API is ready to use...</h3>

```kotlin
    val csApi = CsApi.buildApi("your-key", "your-secret", "path/to/save/auth.json")

    println(csApi.getStockQuote("AAPL"))
```


<h3>NOTES...</h3>