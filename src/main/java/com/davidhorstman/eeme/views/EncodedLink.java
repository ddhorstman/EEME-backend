package com.davidhorstman.eeme.views;

public class EncodedLink {
    private String originalUrl;
    private String encodedUrl;

    public EncodedLink() {
    }

    public EncodedLink(String originalUrl, String encodedUrl) {
        this.originalUrl = originalUrl;
        this.encodedUrl = encodedUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getEncodedUrl() {
        return encodedUrl;
    }

    public void setEncodedUrl(String encodedUrl) {
        this.encodedUrl = encodedUrl;
    }
}
