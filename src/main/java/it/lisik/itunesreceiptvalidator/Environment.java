package it.lisik.itunesreceiptvalidator;

public enum Environment {
    PRODUCTION("https://buy.itunes.apple.com"),
    SANDBOX("https://sandbox.itunes.apple.com");

    private final String serviceUrl;

    Environment(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }
}
