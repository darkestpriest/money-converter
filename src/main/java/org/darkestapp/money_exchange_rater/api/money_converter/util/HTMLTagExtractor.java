package org.darkestapp.money_exchange_rater.api.money_converter.util;

import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 14/04/17.
 */
public class HTMLTagExtractor {

    private static final String CONTEXT = HTMLTagExtractor.class.getSimpleName();

    private HTMLTagExtractor() {
        //Only to avoid public instantiation
    }

    public static String getFirstTextByTagId(String htmlText, String tagID) throws ParseException {

        try {
            if(isHTMLEmpty(htmlText)) {
                throw new ParseException(CONTEXT, "The htmlText cannot be empty");
            }

            Document htmlDocument = Jsoup.parse(htmlText);
            Element htmlElement = htmlDocument.getElementById(tagID);
            if(htmlElement == null) {
                throw new ParseException(
                        CONTEXT,
                        "Cannot find html content related to the tag " + tagID);
            }
            return htmlElement.text();

        } catch (Exception e) {
            throw new ParseException(
                    e,
                    CONTEXT,
                    "An error has occurred parsing an HTML String, please, check the stacktrace");
        }

    }

    private static boolean isHTMLEmpty(String htmlText) {
        return htmlText == null || htmlText.isEmpty();
    }
}
