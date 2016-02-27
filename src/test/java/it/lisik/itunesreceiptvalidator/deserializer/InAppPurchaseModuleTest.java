package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import it.lisik.itunesreceiptvalidator.Environment;
import it.lisik.itunesreceiptvalidator.ReceiptValidator;
import it.lisik.itunesreceiptvalidator.ResponseStatus;
import it.lisik.itunesreceiptvalidator.VerificationResponse;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class InAppPurchaseModuleTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    private URL successfulResponse = InAppPurchaseModuleTest.class.getResource("successful_response.json");
    private String malformedJsonResponse = "{\"status\":21002}";

    @Before
    public void setUp() {
        objectMapper.registerModules(new JodaModule(), new InAppPurchaseModule());
    }

    // todo write proper test
    @Test
    public void testDeserializationForSuccessfulResponse() throws Exception {
        final VerificationResponse value = objectMapper.readValue(successfulResponse.openStream(), VerificationResponse.class);
        assertThat(value.getStatus(), is(ResponseStatus.SUCCESS));
    }

    @Test
    public void testDeserializationForMalfolmedResponse() throws Exception {
        final VerificationResponse value = objectMapper.readValue(malformedJsonResponse, VerificationResponse.class);
        assertThat(value.getStatus(), is(ResponseStatus.MALFORMED_JSON));
        assertThat(value.getReceipt(), is(nullValue()));
    }

    @Test
    public void testAgainstAppleServer() throws Exception {
        new ReceiptValidator(Environment.SANDBOX);
    }

}