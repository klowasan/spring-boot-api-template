package com.jjo.template.application;

import com.jjo.template.application.resource.UserCreateResource;
import com.jjo.template.domain.service.RedisService;
import com.jjo.template.domain.service.UserService;
import com.jjo.template.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody UserCreateResource userCreateResource) {
        redisService.add();
        return userService.create(userCreateResource);
    }

    @GetMapping("/users/total")
    public String getUserTotal() {
        return redisService.get();
    }
}
