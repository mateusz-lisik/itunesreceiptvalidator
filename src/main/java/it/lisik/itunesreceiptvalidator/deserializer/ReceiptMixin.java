package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.lisik.itunesreceiptvalidator.PurchasedItem;
import org.joda.time.DateTime;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ReceiptMixin {
    ReceiptMixin(@JsonProperty("receipt_type") String receiptType, @JsonProperty("adam_id") Integer adamId,
                 @JsonProperty("app_item_id") Integer appItemId, @JsonProperty("bundle_id") String bundleId,
                 @JsonProperty("application_version") String applicationVersion,
                 @JsonProperty("download_id") Integer downloadId,
                 @JsonProperty("version_external_identifier") Integer versionExternalIdentifier,
                 @JsonProperty("receipt_creation_date") DateTime receiptCreationDate,
                 @JsonProperty("request_date") DateTime requestDate,
                 @JsonProperty("original_purchase_date") DateTime originalPurchaseDate,
                 @JsonProperty("original_application_version") String originalApplicationVersion,
                 @JsonProperty("in_app") Set<PurchasedItem> inAppPurchasedItems) {
    }
}
