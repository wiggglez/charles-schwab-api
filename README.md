<h2>INSTRUCTIONS...</h2>


- Requires Charles Schwab account and developer permissions from https://developer.schwab.com. 
  - Obtain an App Key & Secret from this site and follow README.md login instructions.

<h3>INITIAL LOGIN - Must be done once per week.</h3>

There are multiple ways to login. 

- Most Basic: loginBasicCommandLine() as demonstrated below in code.

Complete the login instructions in the console to login.
Once a blank webpage is loaded, copy the url and paste into console and press ENTER.
The access token, refresh token, and account keys will be saved to your auth file path.
You will need to login like this once per week.


```kotlin
fun main() {
    val csApi = CsApi.buildApi("your-key", "your-secret", "path/to/save/auth.json")
    csApi.loginBasicCommandLine()
}
```


<h3>API is ready to use...</h3>

```kotlin
    val csApi = CsApi.buildApi("your-key", "your-secret", "path/to/save/auth.json")

    println(csApi.getStockQuote("AAPL"))
```


- There are other ways to login such as using loginUrl() to get the link to the Charles Schwab login page.
Complete CS Login steps. Once blank webpage is loaded, copy the url. Then call loginWithCode(codeUrl: String)
replacing 'codeUrl: String' parameter with the url from the empty webpage after completing Charles Schwab's login
process



<h3>NOTES...</h3>

- Auth info is saved locally. A path can be provided or left null

- When requesting Historical Data, pay attention to the params. The period param (days, minutes, hours) needs
to be one out of a specific group of numbers. For example when getting a chart by years, you can only get
1, 3, 5, 10 years, NOT 2, 4, 6, 7, 8, 9.
