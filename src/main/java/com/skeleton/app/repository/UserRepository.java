package com.skeleton.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skeleton.app.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
