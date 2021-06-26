package com.jjo.template.config.client;

import com.jjo.template.infrastructure.client.SampleClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties(value = {SampleClientProperties.class})
public class ClientConfig {
    private final SampleClientProperties properties;

    public ClientConfig(SampleClientProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "sample-api")
    public SampleClient makeSampleClient() {
        RestTemplate restTemplate = restTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(properties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .build();

        return new SampleClient(restTemplate, properties.getUrl());
    }

    /**
     * restTemplateBuilder bean (common settings of client)
     *
     * @return RestTemplateBuilder
     */
    private RestTemplateBuilder restTemplateBuilder() {

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setMaxConnTotal(properties.getMaxConnectionTotal())
                .setMaxConnPerRoute(properties.getMaxConnectionPerRoute())
                .disableAutomaticRetries();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());

        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory =
                new BufferingClientHttpRequestFactory(requestFactory);

        return new RestTemplateBuilder().requestFactory(() -> bufferingClientHttpRequestFactory);
    }
}
