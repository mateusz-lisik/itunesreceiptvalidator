package it.lisik.itunesreceiptvalidator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import it.lisik.itunesreceiptvalidator.deserializer.InAppPurchaseModule;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ReceiptValidator {
    public static final String VERIFICATION_ENDPOINT = "/verifyReceipt";
    private final Environment environment;
    private final HttpClient httpClient = HttpClients.createDefault();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ReceiptValidator(Environment environment) {
        this.environment = environment;
        objectMapper.registerModules(new JodaModule(), new InAppPurchaseModule());
    }


    public VerificationResponse verifyReceipt(String base64) throws IOException {
        final HttpPost request = prepareRequest(base64);
        final HttpResponse response = httpClient.execute(request);

        final VerificationResponse verificationResponse;
        try (InputStream inputStream = response.getEntity().getContent()) {
            verificationResponse = objectMapper.readValue(
                    inputStream,
                    VerificationResponse.class
            );
        }

        return verificationResponse;
    }

    private HttpPost prepareRequest(String base64) {
        final HttpPost post = new HttpPost(environment.getServiceUrl() + VERIFICATION_ENDPOINT);
        final HashMap<String, String> requestData = new HashMap<>();
        requestData.put("receipt-data", base64);

        try {
            final HttpEntity entity = EntityBuilder.create()
                    .setText(objectMapper.writeValueAsString(requestData))
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build();

            post.setEntity(entity);
            return post;
        } catch (JsonProcessingException e) {
            throw new AssertionError("This shouldn't happen", e);
        }

    }


}