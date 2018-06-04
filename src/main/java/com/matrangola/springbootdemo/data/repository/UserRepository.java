package com.matrangola.springbootdemo.data.repository;

import com.matrangola.springbootdemo.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
