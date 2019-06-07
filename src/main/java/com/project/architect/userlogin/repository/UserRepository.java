package com.project.architect.userlogin.repository;

import com.project.architect.userlogin.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
