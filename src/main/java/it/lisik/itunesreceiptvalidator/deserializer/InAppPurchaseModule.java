package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import it.lisik.itunesreceiptvalidator.*;
import org.joda.time.DateTime;

public class InAppPurchaseModule extends Module {
    @Override
    public String getModuleName() {
        return "InAppPurchaseModule";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(PurchasedItem.class, PurchasedItemMixin.class);
        context.setMixInAnnotations(Receipt.class, ReceiptMixin.class);
        context.setMixInAnnotations(VerificationResponse.class, VerificationResponseMixin.class);

        final SimpleDeserializers deserializers = prepareDeserializers();
        context.addDeserializers(deserializers);
    }

    private SimpleDeserializers prepareDeserializers() {
        final SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Environment.class, new EnvironmentDeserializer());
        deserializers.addDeserializer(DateTime.class, new AppleDateTimeDeserializer());
        deserializers.addDeserializer(ResponseStatus.class, new ResponseStatusDeserializer());

        return deserializers;
    }
}
