package com.jjo.template.application;

import com.jjo.template.application.resource.UserCreateResource;
import com.jjo.template.domain.service.UserService;
import com.jjo.template.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody UserCreateResource userCreateResource) {
        return userService.create(userCreateResource);
    }
}
