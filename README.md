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
    CurrencyPair currencyPair = new CurrencyPair(USD, BTC);
    ApiObject result = ExchangeApi.getApiObject(currencyPair);
   
    //To get buy price
    result.getBuyPrice();
   
    //To get sell price
    result.getSellPrice();
   ```
