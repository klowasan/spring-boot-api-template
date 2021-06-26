package com.jjo.template.domain.user;

import com.jjo.template.application.resource.UserCreateResource;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public User create(UserCreateResource userCreateResource) {
        return new User(userCreateResource.getName(), userCreateResource.getEmail(), userCreateResource.getPhoneNumber());
    }
}
