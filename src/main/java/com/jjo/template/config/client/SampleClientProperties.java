package com.jjo.template.config.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.jjo.client.sample")
public class SampleClientProperties {
    private String url;
    private int maxConnectionTotal;
    private int maxConnectionPerRoute;
    private int connectionTimeToLiveSec;
    private int connectTimeout;
    private int readTimeout;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMaxConnectionTotal() {
        return maxConnectionTotal;
    }

    public void setMaxConnectionTotal(Integer maxConnectionTotal) {
        this.maxConnectionTotal = maxConnectionTotal;
    }

    public Integer getMaxConnectionPerRoute() {
        return maxConnectionPerRoute;
    }

    public void setMaxConnectionPerRoute(Integer maxConnectionPerRoute) {
        this.maxConnectionPerRoute = maxConnectionPerRoute;
    }

    public Integer getConnectionTimeToLiveSec() {
        return connectionTimeToLiveSec;
    }

    public void setConnectionTimeToLiveSec(Integer connectionTimeToLiveSec) {
        this.connectionTimeToLiveSec = connectionTimeToLiveSec;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }
}
