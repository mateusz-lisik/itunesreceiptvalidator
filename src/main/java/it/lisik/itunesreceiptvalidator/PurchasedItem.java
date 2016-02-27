package it.lisik.itunesreceiptvalidator;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

public class PurchasedItem {
    private final Integer quantity;
    private final String productId;
    private final String transactionId;
    private final String originalTransactionId;
    private final DateTime purchaseDate;
    private final DateTime originalPurchaseDate;
    private final boolean isTrialPeriod;


    public PurchasedItem(Integer quantity, String productId, String transactionId, String originalTransactionId, DateTime purchaseDate, DateTime originalPurchaseDate, boolean isTrialPeriod) {
        this.quantity = quantity;
        this.productId = productId;
        this.transactionId = transactionId;
        this.originalTransactionId = originalTransactionId;
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.isTrialPeriod = isTrialPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantity, productId, transactionId, originalTransactionId, purchaseDate, originalPurchaseDate, isTrialPeriod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PurchasedItem that = (PurchasedItem) o;
        return Objects.equal(isTrialPeriod, that.isTrialPeriod) &&
                Objects.equal(quantity, that.quantity) &&
                Objects.equal(productId, that.productId) &&
                Objects.equal(transactionId, that.transactionId) &&
                Objects.equal(originalTransactionId, that.originalTransactionId) &&
                Objects.equal(purchaseDate, that.purchaseDate) &&
                Objects.equal(originalPurchaseDate, that.originalPurchaseDate);
    }

    /**
     * This value corresponds to the quantity property of the SKPayment object stored in the transaction’s payment
     * property.
     *
     * @return The number of items purchased
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This value corresponds to the productIdentifier property of the SKPayment object stored in the transaction’s
     * payment property.
     *
     * @return The product identifier of the item that was purchased.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This value corresponds to the transaction’s transactionIdentifier property.
     *
     * @return The transaction identifier of the item that was purchased.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This value corresponds to the original transaction’s transactionIdentifier property. All receipts in a chain of
     * renewals for an auto-renewable subscription have the same value for this field.
     *
     * @return For a transaction that restores a previous transaction, the transaction identifier of the original
     * transaction. Otherwise, identical to the transaction identifier.
     */
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    /**
     * This value corresponds to the transaction’s transactionDate property. For a transaction that restores a previous
     * transaction, the purchase date is the date of the restoration. Use Original Purchase Date to get the date of the
     * original transaction. In an auto-renewable subscription receipt, this is always the date when the subscription
     * was purchased or renewed, regardless of whether the transaction has been restored.
     *
     * @return The date and time that the item was purchased.
     */
    public DateTime getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * This value corresponds to the original transaction’s transactionDate property. In an auto-renewable subscription
     * receipt, this indicates the beginning of the subscription period, even if the subscription has been renewed.
     *
     * @return For a transaction that restores a previous transaction, the date of the original transaction.
     */
    public DateTime getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public boolean isTrialPeriod() {
        return isTrialPeriod;
    }
}
