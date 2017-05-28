# Money Exchange Rater
An open source artifact that consults different API's for exchange rates.

This library contains a structure that can easily been scanned by the main class, named ```ApiManager```, this class can scan for available implemented java object that make request and parse the public information retrieved by an exchange public api.


## How to include a new exchange parser
With this library you can add new public api for currency exchange easily, just need to implement ```ExchangeRaterApi``` interface (also you can extends from ```AbstractExchangeRaterApi``` if you want to save some line codes) create the required methods and objects and put your package in the package named ```org.darkestapp.money_exchange_rater.api```. One last step is to include:

```@Api(enabled = true)```

at the beginning of your ExchangeRaterApi implementation and done, the ApiManager can scan the new api implementation.

## How to include new supported currencies
You can include a new currency adding a new element in ```PublicCurrencyCode``` enum, after that, any api can use this new currency within its implementation.

## How to implement in your application
Just create a new instance of ```ApiManager``` class, this class contains a method named:

 ```Map<String, ExchangeRaterApi> getAvailableApiMap()```
 
The method returns a map with all the supported api's, just select one ExchangeRaterApi from the retrieved map and use the method:  
  
```getApiObject(CurrencyPair currencyPair)```

The ```currencyPair``` object must contains the currency to rate, for example:

```Java
    public static void main(String[] args) {

        try {
            ApiManager manager = new ApiManager();
            Map<String, ExchangeRaterApi> apiMap = manager.getAvailableApiMap();
            CurrencyPair currencyPair = CurrencyPairBuilder.build(
                    PublicCurrencyCode.USDT,
                    PublicCurrencyCode.BTC);
            ExchangeRaterApi api;
            ApiObject apiObject;
            for(Map.Entry<String, ExchangeRaterApi> entry : apiMap.entrySet()) {
                api = entry.getValue();
                if(api.getApiId().getShortName().equals("BITT")) {
                    System.out.println("Checking Bittrex API:");

                    apiObject = api.getApiObject(currencyPair);
                    System.out.println(apiObject);

                    //To get buy price
                    System.out.println("Buy price for " + currencyPair.getCurrenciesCodes() + "\n"
                            + "\t" + apiObject.getBuyPrice());

                    //To get sell price
                    System.out.println("Sell price for " + currencyPair.getCurrenciesCodes() + "\n"
                            + "\t" +apiObject.getSellPrice());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   ```

If you want to use this artifact in your Kotlin application, you can use the following lines as example:

```Kotlin
    fun main(args: Array<String>) {

        try {
            val manager = ApiManager()
            val map = manager.availableApiMap
            val currencyPair = CurrencyPairBuilder.build(
                    PublicCurrencyCode.USDT,
                    PublicCurrencyCode.BTC)
            for((code, api) in map) {
                if(api.apiId.shortName.equals("BITT")) {
                    println("Checking Bittrex API:")

                    val apiObject = api.getApiObject(currencyPair)
                    println(apiObject)

                    //To get buy price
                    println("Buy price for " + currencyPair.currenciesCodes + "\n"
                            + "\t" + apiObject.buyPrice)

                    //To get sell price
                    println("Sell price for " + currencyPair.currenciesCodes + "\n"
                            + "\t" + apiObject.sellPrice)
                }
                println(code)
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
```

## How to include in your app.
The artifact is hosted in jcenter, you need to include jcenter in your repositories sources. If you are using gradle, to include this library using the following lines:
  
```Gradle
    compile 'org.darkestapp.money-exchange-rater:money-exchange-rater:1.0.1'
```
For maven users, you can include in your pom file:
```Maven
<dependency>
  <groupId>org.darkestapp.money-exchange-rater</groupId>
  <artifactId>money-exchange-rater</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```
