package com.jjo.template.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private String key = "stock:total";

    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;

    public void add() {
        redisTemplate.opsForValue().set(key, "test");
    }

    public String get() {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
