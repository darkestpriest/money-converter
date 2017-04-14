package org.darkestapp.money_exchange_rater.api.money_converter.util;

import org.darkestapp.money_exchange_rater.api.money_converter.exceptions.ParseException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 14/04/17.
 */
public class HTMLTagExtractorTest {

    private static final String HTML_TEXT = "<html><body>" +
            "<div id='testId'>Test text</div><br>" +
            "<input type='submit' value='Send Test'>" +
            "</body>" +
            "</html>";
    private static final String MALFORMED_HTML = "<html <ody>>";

    @Test
    public void getFirstTextByTagIdCorrectId() throws Exception {
        String result = HTMLTagExtractor.getFirstTextByTagId(HTML_TEXT, "testId");
        assertEquals("Test text", result);
    }

    @Test(expected = ParseException.class)
    public void getFirstTextByTagIdWrongId() throws Exception {
        HTMLTagExtractor.getFirstTextByTagId(HTML_TEXT, "wrongId");
    }

    @Test(expected = ParseException.class)
    public void getFirstTextByTagIdNullHTML() throws Exception {
        HTMLTagExtractor.getFirstTextByTagId(null, "wrongId");
    }

    @Test(expected = ParseException.class)
    public void getFirstTextByTagIdEmptyHTML() throws Exception {
        HTMLTagExtractor.getFirstTextByTagId("", "wrongId");
    }

    @Test(expected = ParseException.class)
    public void getFirstTextByTagIdMalformedHTML() throws Exception {
        HTMLTagExtractor.getFirstTextByTagId(MALFORMED_HTML, "wrongId");
    }

}