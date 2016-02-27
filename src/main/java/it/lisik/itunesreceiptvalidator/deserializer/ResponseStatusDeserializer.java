package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import it.lisik.itunesreceiptvalidator.ResponseStatus;

import java.io.IOException;

public class ResponseStatusDeserializer extends JsonDeserializer<ResponseStatus> {
    @Override
    public ResponseStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        for (ResponseStatus status : ResponseStatus.values()) {
            if (status.getErrorCode() != p.getValueAsInt()) continue;
            return status;
        }

        throw new InvalidFormatException(p, "Cannot decode this ResponseStatus", p.getIntValue(), ResponseStatus.class);
    }
}
