package com.jjo.template.domain.service;

import com.jjo.template.application.resource.UserCreateResource;
import com.jjo.template.domain.user.User;
import com.jjo.template.domain.user.UserFactory;
import com.jjo.template.infrastructure.user.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private UserFactory userFactory;

    @Transactional(readOnly = true)
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public User create(UserCreateResource userCreateResource) {
        User user = userFactory.create(userCreateResource);
        return userRepository.<User>save(user);
    }
}
