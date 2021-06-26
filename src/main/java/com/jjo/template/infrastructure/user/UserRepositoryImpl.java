package com.jjo.template.infrastructure.user;

import com.jjo.template.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
