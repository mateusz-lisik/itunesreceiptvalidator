package it.lisik.itunesreceiptvalidator.deserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PurchasedItemMixin {
    PurchasedItemMixin(@JsonProperty("quantity") Integer quantity, @JsonProperty("product_id") String productId,
                       @JsonProperty("transaction_id") String transactionId,
                       @JsonProperty("original_transaction_id") String originalTransactionId,
                       @JsonProperty("purchase_date") DateTime purchaseDate,
                       @JsonProperty("original_purchase_date") DateTime originalPurchaseDate,
                       @JsonProperty("is_trial_period") boolean isTrialPeriod) {
    }

}
