#? Source: https://bonigarcia.dev/webdrivermanager/
# 7.4. Support for chromedriver 115+
The chromedriver team has stopped publishing the chromedriver releases and metadata using their traditional chromedriver download repository with chromedriver 114. This way, as of chromedriver 115, the chromedriver releases can only be discovered programmatically using the Chrome for Testing (CfT) JSON endpoints.

This change is very relevant for WebDriverManager, since, as of Chrome 115 and 116, chromedriver cannot be managed automatically by WebDriverManager using the traditional way. Therefore, for older versions of WebDriverManager, this situation led to errors like the following:

io.github.bonigarcia.wdm.online.HttpClient: Error HTTP 404 executing https://chromedriver.storage.googleapis.com/LATEST_RELEASE_116
org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: session not created: This version of ChromeDriver only supports Chrome version 114
WebDriverManager 5.4+ implements the support for the CfT endpoints. Therefore, the solution to this problem is to bump WebDriverManager to the latest version (5.7.0 currently). Also, to ensure that the wrong version has not been cached in the resolution cache, you can refresh completely the cache folder (at least once) as follows:

WebDriverManager.chromedriver().clearDriverCache().setup();
