package com.eindproject.v4.repository;

import com.eindproject.v4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
