package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.lisik.itunesreceiptvalidator.Environment;
import it.lisik.itunesreceiptvalidator.Receipt;
import it.lisik.itunesreceiptvalidator.ResponseStatus;

abstract class VerificationResponseMixin {
    VerificationResponseMixin(@JsonProperty("status") ResponseStatus status,
                              @JsonProperty("environment") Environment environment,
                              @JsonProperty("receipt") Receipt receipt) {
    }
}
