package com.jjo.template.infrastructure.client;

import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.RestTemplate;

public class SampleClient {
    private RestTemplate restTemplate;
    private static String url;
    private static String uri = "/test";

    public SampleClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Retryable(value = {ConnectTimeoutException.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000L))
    public <T> T post(Object request, Class<T> responseType) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<T> res = restTemplate.postForEntity(
                url + uri,
                request,
                responseType
        );

        if (!res.getStatusCode().equals(HttpStatus.OK)) {
            throw new Exception();
        }

        return res.getBody();
    }
}
