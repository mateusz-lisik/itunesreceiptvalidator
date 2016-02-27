package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import it.lisik.itunesreceiptvalidator.Environment;

import java.io.IOException;

class EnvironmentDeserializer extends JsonDeserializer<Environment> {
    @Override
    public Environment deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return Environment.valueOf(p.getValueAsString().toUpperCase());
    }
}
