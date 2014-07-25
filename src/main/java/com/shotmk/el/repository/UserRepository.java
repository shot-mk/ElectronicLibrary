package com.shotmk.el.repository;

import com.shotmk.el.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
