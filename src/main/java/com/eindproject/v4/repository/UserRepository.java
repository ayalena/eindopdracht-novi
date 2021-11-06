package com.eindproject.v4.repository;

import com.eindproject.v4.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
