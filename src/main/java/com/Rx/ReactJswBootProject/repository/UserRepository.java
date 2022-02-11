package com.Rx.ReactJswBootProject.repository;

import com.Rx.ReactJswBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
