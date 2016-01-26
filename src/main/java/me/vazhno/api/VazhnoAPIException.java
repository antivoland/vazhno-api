package me.vazhno.api;

public class VazhnoAPIException extends Exception {
    public VazhnoAPIException(VazhnoAPIResponse.Error error) {
        super(error.message);
    }

    public VazhnoAPIException(Throwable cause) {
        super(cause);
    }
}
