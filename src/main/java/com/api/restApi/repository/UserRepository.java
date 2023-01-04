package com.api.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.restApi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {}
