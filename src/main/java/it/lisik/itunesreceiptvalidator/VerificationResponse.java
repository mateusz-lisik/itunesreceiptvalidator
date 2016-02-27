package it.lisik.itunesreceiptvalidator;

public class VerificationResponse {
    private final ResponseStatus status;
    private final Environment environment;
    private final Receipt receipt;

    VerificationResponse(ResponseStatus status, Environment environment, Receipt receipt) {
        this.status = status;
        this.environment = environment;
        this.receipt = receipt;
    }

    /**
     * @return Validation status responded by iTunes Server
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * @return Environment which was used to verify receipt
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @return Receipt fetched from iTunes response
     */
    public Receipt getReceipt() {
        return receipt;
    }
}
