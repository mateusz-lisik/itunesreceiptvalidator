package it.lisik.itunesreceiptvalidator;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateTime;

import java.util.Set;

public class Receipt {
    private final String receiptType;
    private final Integer adamId;
    private final Integer appItemId;
    private final String bundleId;
    private final String applicationVersion;
    private final Integer downloadId;
    private final Integer versionExternalIdentifier;
    private final DateTime receiptCreationDate;
    private final DateTime requestDate;
    private final DateTime originalPurchaseDate;
    private final String originalApplicationVersion;
    private final Set<PurchasedItem> inAppPurchasedItems;


    public Receipt(String receiptType, Integer adamId, Integer appItemId, String bundleId, String applicationVersion, Integer downloadId, Integer versionExternalIdentifier, DateTime receiptCreationDate, DateTime requestDate, DateTime originalPurchaseDate, String originalApplicationVersion, Set<PurchasedItem> inAppPurchasedItems) {
        this.receiptType = receiptType;
        this.adamId = adamId;
        this.appItemId = appItemId;
        this.bundleId = bundleId;
        this.applicationVersion = applicationVersion;
        this.downloadId = downloadId;
        this.versionExternalIdentifier = versionExternalIdentifier;
        this.receiptCreationDate = receiptCreationDate;
        this.requestDate = requestDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.originalApplicationVersion = originalApplicationVersion;
        this.inAppPurchasedItems = inAppPurchasedItems;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public Integer getAdamId() {
        return adamId;
    }

    public Integer getAppItemId() {
        return appItemId;
    }

    public String getBundleId() {
        return bundleId;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public Integer getDownloadId() {
        return downloadId;
    }

    public Integer getVersionExternalIdentifier() {
        return versionExternalIdentifier;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(receiptType, adamId, appItemId, bundleId, applicationVersion, downloadId, versionExternalIdentifier, receiptCreationDate, requestDate, originalPurchaseDate, originalApplicationVersion, inAppPurchasedItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Receipt receipt = (Receipt) o;
        return Objects.equal(receiptType, receipt.receiptType) &&
                Objects.equal(adamId, receipt.adamId) &&
                Objects.equal(appItemId, receipt.appItemId) &&
                Objects.equal(bundleId, receipt.bundleId) &&
                Objects.equal(applicationVersion, receipt.applicationVersion) &&
                Objects.equal(downloadId, receipt.downloadId) &&
                Objects.equal(versionExternalIdentifier, receipt.versionExternalIdentifier) &&
                Objects.equal(receiptCreationDate, receipt.receiptCreationDate) &&
                Objects.equal(requestDate, receipt.requestDate) &&
                Objects.equal(originalPurchaseDate, receipt.originalPurchaseDate) &&
                Objects.equal(originalApplicationVersion, receipt.originalApplicationVersion) &&
                Objects.equal(inAppPurchasedItems, receipt.inAppPurchasedItems);
    }

    public DateTime getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public DateTime getRequestDate() {
        return requestDate;
    }

    public DateTime getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public String getOriginalApplicationVersion() {
        return originalApplicationVersion;
    }

    public Set<PurchasedItem> getInAppPurchasedItems() {
        return ImmutableSet.copyOf(inAppPurchasedItems);
    }
}
