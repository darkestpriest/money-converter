package org.darkestapp.money_exchange_rater.interfaces;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static org.darkestapp.money_exchange_rater.config.PublicConstants.DEFAULT_USER_AGENT;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 16/04/17.
 */
public abstract class JsonParser<A extends ApiObject, C extends CurrencyPair> {

    private static final int SUCCESS_CODE = 200;
    private static final String EXCEPTION_MESSAGE = "Json Parser error";
    private static final String EXCEPTION_MESSAGE_PREFIX = "The URL ";

    protected final String CONTEXT;

    public JsonParser(Class context) {
        this.CONTEXT = context.getSimpleName();
    }

    public abstract A getApiObject(String url, C currencyPair) throws MoneyExchangeRaterException;

    protected JSONObject getRequest(String stringURL) throws MoneyExchangeRaterException {

        try {

            URL url = new URL(stringURL);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.addRequestProperty("User-Agent", DEFAULT_USER_AGENT);
            if(connection == null) {

                throw new MoneyExchangeRaterException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        "The Https connection is null");
            }

            int responseCode = connection.getResponseCode();
            if(responseCode != SUCCESS_CODE) {

                throw new MoneyExchangeRaterException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        EXCEPTION_MESSAGE_PREFIX + stringURL + " respond with " + responseCode + " code");
            }

            String response = getStringResponse(connection);

            if(response == null || response.isEmpty()) {

                throw new MoneyExchangeRaterException(
                        EXCEPTION_MESSAGE,
                        null,
                        CONTEXT,
                        EXCEPTION_MESSAGE_PREFIX + stringURL + " respond is empty or null");
            }

            return new JSONObject(response);
        } catch (MalformedURLException e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    EXCEPTION_MESSAGE_PREFIX + stringURL + " is malformed");
        } catch (IOException e) {
            throw new MoneyExchangeRaterException(
                    EXCEPTION_MESSAGE,
                    e,
                    CONTEXT,
                    EXCEPTION_MESSAGE_PREFIX + stringURL + " request gets an IOException.");
        }
    }

    private String getStringResponse(HttpsURLConnection connection) throws IOException {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null){
            response.append(input);
        }
        br.close();

        return response.toString();
    }
}
