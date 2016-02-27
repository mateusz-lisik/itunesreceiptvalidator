package it.lisik.itunesreceiptvalidator;

public enum ResponseStatus {
    SUCCESS(0),
    MALFORMED_JSON(21002),
    RECEIPT_NOT_AUTHENTICATED(21003),
    RECEIPT_SERVER_NOT_AVAILABLE(21005),
    TEST_RECEIPT_SENT_TO_PRODUCTION(21007),
    PRODUCTION_RECEIPT_SENT_TO_TEST(21008);

    private final int errorCode;

    ResponseStatus(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
